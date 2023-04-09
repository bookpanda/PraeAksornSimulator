package pane;

import components.plate.Plate;
import javafx.scene.layout.BorderPane;

public class RootPane extends BorderPane {
	private static Plate plate;

	public RootPane() {
		plate = new Plate();
		this.setCenter(plate);
	}

	public static Plate getPlate() {
		return plate;
	}
}
