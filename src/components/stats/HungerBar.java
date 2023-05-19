/**
 * Displays hunger bar and controls hunger level
 */
package components.stats;

import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class HungerBar extends StatsBar {
	private static HungerBar hungerBar = null;
	private int hunger = 200;
	private Text text;

	private HungerBar() {
		this.text = new Text(String.valueOf(hunger));
		this.getChildren().add(this.text);
		this.setBackground(new Background(new BackgroundFill(Color.ORANGE, null, null)));
	}

	public static HungerBar getInstance() {
		if (hungerBar == null)
			hungerBar = new HungerBar();
		return hungerBar;
	}

	/**
	 * Updates both the display and actual value
	 */
	public void replenish() {
		this.setStats(Math.max(0, Math.min(200, hunger + 40)));
		this.setWidth(Math.max(0, Math.min(200, hunger + 40)));
	}

	public int getStats() {
		return hunger;
	}

	public void setStats(int hunger) {
		this.hunger = hunger;
		this.text.setText(String.valueOf(hunger));
	}

	public String getName() {
		return "hunger";
	}

}
