/**
 * Runnable for eating and drinking
 */
package components.inventory;

import components.stats.StatsBar;
import utils.AmbiencePlayer;

public class UseRunnable extends Thread {
	StatsBar statsBar;

	public UseRunnable(StatsBar statsBar) {
		this.statsBar = statsBar;
		start();
	}

	@Override
	public void run() {
		AmbiencePlayer.loadSound(statsBar.getName());
		AmbiencePlayer.playSound();
		try {
			Thread.sleep(1000);
			statsBar.replenish();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		AmbiencePlayer.stopSound();
	}
}
