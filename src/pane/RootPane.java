package pane;

import components.inventory.Inventory;
import components.plate.Plate;
import components.timer.Timer;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;



public class RootPane extends BorderPane {
	private static Plate plate;
	private static Timer timer;
	private static Inventory inventory;

	public RootPane() {
		
		
		plate = new Plate();
		timer = new Timer();
		inventory = new Inventory();
		this.setTop(timer);
		this.setCenter(plate);
		BorderPane.setMargin(inventory, new Insets(20,0,20,0));
		this.setBottom(inventory);
	}

	public static Plate getPlate() {
		return plate;
	}
}
