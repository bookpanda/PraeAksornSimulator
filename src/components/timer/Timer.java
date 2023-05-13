package components.timer;

import javafx.application.Platform;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class Timer extends VBox {
	private int seconds;
	private boolean active;

	public Timer() {
		setSeconds(60);
		Text text = new Text("Time left");
		Text timeText = new Text(String.valueOf(seconds));
		this.getChildren().addAll(text, timeText);

		Thread thread = new Thread(() -> {
			try {
				while (seconds > 0) {
					Thread.sleep(1000);
					Platform.runLater(new Runnable() {
						@Override
						public void run() {
							timeText.setText(String.valueOf(seconds));
						}
					});
					setSeconds(seconds - 1);
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		thread.start();
	}

	public int getSeconds() {
		return seconds;
	}

	public void setSeconds(int seconds) {
		this.seconds = seconds;
	}
}
