package components.timer;

import components.code.CodeWrapper;
import components.plate.Paper;
import components.plate.PaperBox;
import components.plate.Plate;
import components.plate.RowOfPaper;
import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.util.Pair;
import pane.RootPane;
import pane.ScorePane;
import score.Score;
import utils.MusicPlayer;

public class TimeRunnable implements Runnable {
	private CodeWrapper codeWrapper = CodeWrapper.getInstance();
	private Timer timer = Timer.getInstance();
	private RootPane rootPane = RootPane.getInstance();
	private Plate plate = Plate.getInstance();
	private Score score = Score.getInstance();
	private ScorePane scorePane = ScorePane.getInstance();
	private int points;

	public void run() {
		try {
			for (int i = 0; i < 5; i++) {
				timer.setSeconds(60);
				codeWrapper.getNewIndex();
				String codeName = codeWrapper.getCurrentCodeName();
				BackgroundImage bi = new BackgroundImage(
						new Image("images/" + codeName + "_stand.png", 1000, 700, false, true), BackgroundRepeat.REPEAT,
						BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
				rootPane.setBackground(new Background(bi));
				MusicPlayer.loadMusic(codeName);
				MusicPlayer.playMusic();
				int[][] currentCode = codeWrapper.getCurrentCode();
				while (timer.getSeconds() > 0) {
					Pair<Boolean, Integer> result = calculateScore(currentCode);
					boolean isPlateComplete = result.getKey();
					points = result.getValue();
					if (isPlateComplete) {
						break;
					}
					Thread.sleep(1000);
					Platform.runLater(new Runnable() {
						@Override
						public void run() {
							timer.getTimeText().setText(String.valueOf(timer.getSeconds()));
						}
					});
					timer.setSeconds(timer.getSeconds() - 1);
				}
				score.setPoints(score.getPoints() + points);
				System.out.println("points : " + points);
				Platform.runLater(new Runnable() {
					@Override
					public void run() {
						scorePane.setScoreText(points);
					}
				});
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Pair<Boolean, Integer> calculateScore(int[][] currentCode) {
		GridPane gp = (GridPane) plate.getChildren().get(1);
		int point = 0;
		boolean flag = true;
		int col = 0;
		for (Node node : gp.getChildren()) {
			int row = 0;
			RowOfPaper rop = (RowOfPaper) node; // 4 paper
			VBox vbox = (VBox) rop.getChildren().get(0);
			for (Node n : vbox.getChildren()) {
				if (row > 3)
					break;
				PaperBox pb = (PaperBox) n;
				Paper p = (Paper) pb.getChildren().get(1);
				if (p.getPage() != currentCode[row][col]) {
					flag = false;
				} else {
					point += 500;
				}
				row += 1;
			}
			col += 1;
		}
		point += Math.floor(point * ((double) timer.getSeconds() / 60));
		return new Pair<Boolean, Integer>(flag, point);
	}
}
