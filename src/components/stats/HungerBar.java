package components.stats;

import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class HungerBar extends HBox implements StatsBar {
	private static HungerBar hungerBar = null;
	private int hunger = 200;
	private Text text;

	private HungerBar() {
		this.text = new Text(String.valueOf(hunger));
		this.setPrefHeight(20);
		this.setMaxWidth(200);
		this.getChildren().add(this.text);
		this.setBackground(new Background(new BackgroundFill(Color.ORANGE, null, null)));
	}

	public static HungerBar getInstance() {
		if (hungerBar == null)
			hungerBar = new HungerBar();
		return hungerBar;
	}

	public void replenish() {
		this.setHunger(Math.max(0, Math.min(200, hunger + 40)));
	}

	public int getHunger() {
		return hunger;
	}

	public void setHunger(int hunger) {
		this.hunger = hunger;
		this.text.setText(String.valueOf(hunger));
	}

	public String getName() {
		return "hunger";
	}

}
