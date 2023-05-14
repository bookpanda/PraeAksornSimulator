package components.stats;

import javafx.scene.layout.HBox;

public class ThirstBar extends HBox implements StatsBar {
	private static ThirstBar thirstBar = null;

	private ThirstBar() {

	}

	public static ThirstBar getInstance() {
		if (thirstBar == null)
			thirstBar = new ThirstBar();
		return thirstBar;
	}

	public void replenish() {
	}

	public String getName() {
		return "thirst";
	}

}
