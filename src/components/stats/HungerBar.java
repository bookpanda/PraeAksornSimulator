package components.stats;

import javafx.scene.layout.HBox;

public class HungerBar extends HBox implements StatsBar {
	private static HungerBar hungerBar = null;

	private HungerBar() {

	}

	public static HungerBar getInstance() {
		if (hungerBar == null)
			hungerBar = new HungerBar();
		return hungerBar;
	}

	public void replenish() {
	}

	public String getName() {
		return "hunger";
	}

}
