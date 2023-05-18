package components.plate;

import java.util.Random;

import components.stats.HungerBar;
import components.stats.ThirstBar;
import components.timer.Timer;
import javafx.geometry.Pos;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import utils.AmbiencePlayer;

public class Paper extends PaperAbove {
	private int[] textWhite = { 2, 4, 6, 8, 9, 15, 19, 20, 21, 24, 25, 26, 27, 28, 29, 30 };
	private Text text = new Text();
<<<<<<< HEAD
=======
	private Timer timer = Timer.getInstance();
	private HungerBar hungerBar = HungerBar.getInstance();
	private ThirstBar thirstBar = ThirstBar.getInstance();
	private Random random = new Random();
>>>>>>> 814afd292698550ec5d41da60cf8fe7fe8491094

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
		if (timer.isActive() && hungerBar.getStats() >= 100) {
			if (0 <= number && number <= 31) {
				AmbiencePlayer.loadSound("flip");
				AmbiencePlayer.playSound();
			}
			int variance = 0;
			if (thirstBar.getStats() < 100) {
				int range = Math.abs(thirstBar.getStats() - 100) / 10;
				variance = random.nextInt(range + range) - range;
			}
			super.flipToPage(number + variance);
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
