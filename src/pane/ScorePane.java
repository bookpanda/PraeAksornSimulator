package pane;

import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class ScorePane extends VBox {
	private static ScorePane scorePane = null;
	private Text scoreText;

	private ScorePane() {
		Text text = new Text("Score");
		text.setFont(new Font(null, 20));
		scoreText = new Text("0");
		scoreText.setFont(new Font(null, 20));
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
