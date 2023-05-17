package components.stats;

import javafx.application.Platform;

public class ThirstRunnable implements Runnable {
	private ThirstBar thirstBar = ThirstBar.getInstance();
	private int thirst;

	public void run() {
		try {
			thirst = thirstBar.getThirst();
			while (thirst > 0) {
				Thread.sleep(300);
				thirst = thirstBar.getThirst();
				thirstBar.setThirst(thirst - 1);
				thirst = thirstBar.getThirst();
				Platform.runLater(new Runnable() {
					@Override
					public void run() {
						thirstBar.setMaxWidth(thirst);
					}
				});
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
