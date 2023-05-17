package pane;

import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import score.Score;

public class ScorePane extends VBox {
	private static ScorePane scorePane = null;
	private Text scoreText;

	private ScorePane() {
		Score score = Score.getInstance();
		Text text = new Text("Score");
		scoreText = new Text(String.valueOf(score.getPoints()));
		this.getChildren().addAll(text, scoreText);
	}

	public void setScoreText(int newScore) {
		scoreText.setText(String.valueOf(newScore));
	}

	public static ScorePane getInstance() {
		if (scorePane == null) {
			scorePane = new ScorePane();
		}
		return scorePane;
	}

}
