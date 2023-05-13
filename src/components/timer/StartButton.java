package components.timer;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class StartButton extends Button {
	Timer timer = Timer.getInstance();
	public StartButton() {
		this.setText("Start");
		this.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				timer.start();
			}
		});
	}

}
