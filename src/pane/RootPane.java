package pane;

import components.plate.Plate;
import components.timer.Timer;
import javafx.scene.layout.BorderPane;



public class RootPane extends BorderPane {
	private static Plate plate;
	private static Timer timer;

	public RootPane() {
		
		
		plate = new Plate();
		timer = new Timer();
		this.setTop(timer);
		this.setCenter(plate);
	}

	public static Plate getPlate() {
		return plate;
	}
}
