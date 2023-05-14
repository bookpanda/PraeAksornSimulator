package components.timer;

import components.code.CodeWrapper;
import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import pane.RootPane;
import utils.MusicPlayer;

public class CodeRunnable implements Runnable {
	private CodeWrapper codeWrapper = CodeWrapper.getInstance();
	private Timer timer = Timer.getInstance();

	public void run() {
		try {
			String codeName = codeWrapper.getCurrentCodeName();
			BackgroundImage bi = new BackgroundImage(
					new Image("images/" + codeName + "_stand.png", 1000, 700, false, true), BackgroundRepeat.REPEAT,
					BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
			RootPane rootPane = RootPane.getInstance();
			rootPane.setBackground(new Background(bi));
			MusicPlayer.loadMusic(codeName);
			MusicPlayer.playMusic();
			while (timer.getSeconds() > 0) {
				Thread.sleep(1000);
				Platform.runLater(new Runnable() {
					@Override
					public void run() {
						timer.getTimeText().setText(String.valueOf(timer.getSeconds()));
					}
				});
				timer.setSeconds(timer.getSeconds() - 1);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
