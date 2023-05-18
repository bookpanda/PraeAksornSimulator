package score;

import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Score extends VBox {
	private static Score score = null;
	private Text scoreText;
	private int points;

	private Score() {
		Text text = new Text("Score");
		text.setFont(new Font(null, 20));
		scoreText = new Text();
		scoreText.setFont(new Font(null, 20));
		setPoints(0);
		this.getChildren().addAll(text, scoreText);
	}

	public static Score getInstance() {
		if (score == null) {
			score = new Score();
		}
		return score;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		scoreText.setText(String.valueOf(points));
		this.points = points;
	}

}
