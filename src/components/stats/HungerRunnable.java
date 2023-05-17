package components.stats;

import javafx.application.Platform;

public class HungerRunnable implements Runnable {
	private HungerBar hungerBar = HungerBar.getInstance();
	private int hunger;

	public void run() {
		try {
			hunger = hungerBar.getHunger();
			while (hunger > 0) {
				Thread.sleep(500);
				hunger = hungerBar.getHunger();
				hungerBar.setHunger(hunger - 1);
				hunger = hungerBar.getHunger();
				Platform.runLater(new Runnable() {
					@Override
					public void run() {
						hungerBar.setMaxWidth(hunger);
					}
				});
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}