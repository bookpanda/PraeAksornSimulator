package components.timer;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class StartButton extends BaseButton {
	private static StartButton startButton = null;
	Timer timer = Timer.getInstance();

	private StartButton() {
		super("Start");
		this.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				timer.start();
			}
		});
	}
	
	public static StartButton getInstance() {
		if (startButton == null) {
			startButton = new StartButton();
		}
		return startButton;
	}

}
