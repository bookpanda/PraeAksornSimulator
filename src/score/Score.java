package score;

import pane.ScorePane;

public class Score {
	private ScorePane scorePane = ScorePane.getInstance();
	private static Score score = null;
	private int points;

	private Score() {
		setPoints(0);
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
		scorePane.setScoreText(points);
		this.points = points;
	}

}
