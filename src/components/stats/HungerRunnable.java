package components.stats;

import javafx.application.Platform;

public class HungerRunnable implements Runnable {
	private HungerBar hungerBar = HungerBar.getInstance();
	private int hunger;

	public void run() {
		try {
			hunger = hungerBar.getHunger();
			while (hunger > 0) {
				Thread.sleep(2000);
				hungerBar.setHunger(hunger - 10);
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