package pane;

import components.inventory.Inventory;
import components.plate.Plate;
import components.timer.Timer;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.input.ScrollEvent;
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
		BorderPane.setMargin(inventory, new Insets(20, 0, 20, 0));
		this.setBottom(inventory);

		this.setOnScroll(new EventHandler<ScrollEvent>() {
			public void handle(ScrollEvent event) {
				double deltaY = event.getDeltaY();
				if (deltaY > 0) {
					int newIdx = inventory.getIndex() - 1;
					if (newIdx < 0)
						inventory.setIndex(inventory.getSize() - 1);
					else
						inventory.setIndex(newIdx);
				} else if (deltaY < 0) {
					int newIdx = inventory.getIndex() + 1;
					if (newIdx >= inventory.getSize())
						inventory.setIndex(0);
					else
						inventory.setIndex(newIdx);
				}
			}
		});
	}

	public static Plate getPlate() {
		return plate;
	}
}
