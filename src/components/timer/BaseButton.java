package components.timer;
import javafx.scene.control.Button;
import javafx.scene.text.Font;

public class BaseButton extends Button {
	public BaseButton(String name) {
		this.setPrefWidth(100);
		this.setText(name);
		this.setFont(new Font(null, 20));
	}
}
