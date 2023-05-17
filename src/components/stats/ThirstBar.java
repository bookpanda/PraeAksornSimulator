package components.stats;

import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class ThirstBar extends HBox implements StatsBar {
	private static ThirstBar thirstBar = null;
	private int thirst = 200;
	private Text text;

	private ThirstBar() {
		this.text = new Text(String.valueOf(thirst));
		this.setPrefHeight(20);
		this.setMaxWidth(200);
		this.getChildren().add(this.text);
		this.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, null, null)));
	}

	public static ThirstBar getInstance() {
		if (thirstBar == null)
			thirstBar = new ThirstBar();
		return thirstBar;
	}

	public void replenish() {
		this.setThirst(Math.max(0, Math.min(200, thirst + 10)));
		this.setWidth(Math.max(0, Math.min(200, thirst + 10)));
	}

	public int getThirst() {
		return thirst;
	}

	public void setThirst(int thirst) {
		this.thirst = thirst;
		this.text.setText(String.valueOf(thirst));
	}

	public String getName() {
		return "thirst";
	}

}
