/**
 * Button for exiting program
 */
package components.timer;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ExitButton extends BaseButton {
	Timer timer = Timer.getInstance();

	public ExitButton() {
		super("Exit");
		this.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				timer.exit();
			}
		});
	}
}
