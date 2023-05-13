package components.timer;

import components.code.CodeWrapper;
import javafx.application.Platform;
import utils.MusicPlayer;

public class CodeRunnable implements Runnable {
	private CodeWrapper codeWrapper = CodeWrapper.getInstance();
	private Timer timer = Timer.getInstance();

	public void run() {
		try {
			String codeName = codeWrapper.getCurrentCodeName();
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
