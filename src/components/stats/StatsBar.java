/**
 * HungerBar and ThirstBar extends from StatsBar
 */
package components.stats;

import javafx.scene.layout.HBox;

public abstract class StatsBar extends HBox {
	public StatsBar() {
		this.setPrefHeight(20);
		this.setMaxWidth(200);
	}

	public abstract String getName();

	public abstract void replenish();

	public abstract int getStats();

	public abstract void setStats(int newStats);
}
