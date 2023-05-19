/**
 * Runnable for running HungerBar and ThirstBar during the game
 */
package components.stats;

import javafx.application.Platform;

public class StatsRunnable implements Runnable {
	private StatsBar statsBar;
	private int stats;
	private int rate;

	public StatsRunnable(StatsBar statsBar, int stats, int rate) {
		this.statsBar = statsBar;
		this.stats = stats;
		this.rate = rate;
	}

	/**
	 * Decreases hunger/thirst by 1 every specified time interval
	 */
	public void run() {
		try {
			stats = statsBar.getStats();
			while (true) {
				Thread.sleep(rate);
				stats = statsBar.getStats();
				statsBar.setStats(Math.max(0, stats - 1));
				stats = statsBar.getStats();
				Platform.runLater(new Runnable() {
					@Override
					public void run() {
						statsBar.setMaxWidth(stats);
					}
				});
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}