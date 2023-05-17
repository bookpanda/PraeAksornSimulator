package components.timer;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class PauseButton extends BaseButton {
	private static PauseButton pauseButton = null;
	private Timer timer = Timer.getInstance();

	private PauseButton() {
		super("Pause");
		this.setDisable(true);
		this.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				timer.pause();
			}
		});
	}

	public static PauseButton getInstance() {
		if (pauseButton == null) {
			pauseButton = new PauseButton();
		}
		return pauseButton;
	}
}
