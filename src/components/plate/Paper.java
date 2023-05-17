package components.plate;

import components.timer.Timer;
import javafx.geometry.Pos;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import utils.AmbiencePlayer;

public class Paper extends PaperAbove {
	private int[] textWhite = { 2, 4, 6, 8, 9, 15, 19, 20, 21, 24, 25, 26, 27, 28, 29, 30 };
	Text text = new Text();

	public Paper() {
		this.setPrefHeight(50);
		this.setPrefWidth(100);
		this.setStyle("-fx-background-color: " + this.getColor() + ";");
		this.setSpacing(20);
		this.setAlignment(Pos.CENTER);
		text.setText(this.getText());
		text.setStyle("-fx-font: 25 arial;");
		this.getChildren().add(text);
		this.setVisible(true);

	}

	public void flipToPage(int number) {
		Timer timer = Timer.getInstance();
		if (timer.isActive()) {
			if (0 <= number && number <= 31) {
				AmbiencePlayer.loadSound("flip");
				AmbiencePlayer.playSound();
			}
			super.flipToPage(number);
			text.setText(this.getText());
			boolean flag = true;
			for (int idx : textWhite) {
				if (idx == this.getPage()) {
					text.setFill(Color.WHITE);
					flag = false;
					break;
				}
			}
			if (flag)
				text.setFill(Color.BLACK);

			this.setVisible(true);
			if (this.getPage() >= 31) {
				this.setVisible(false);
			}
		}
	}
}
