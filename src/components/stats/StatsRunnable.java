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

	public void run() {
		try {
			stats = statsBar.getStats();
			while (stats > 0) {
				Thread.sleep(rate);
				stats = statsBar.getStats();
				statsBar.setStats(stats - 1);
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