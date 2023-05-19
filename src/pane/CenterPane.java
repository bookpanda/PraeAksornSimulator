/**
 * Center part of RootPane (Plate)
 */
package pane;

import components.inventory.Inventory;
import components.inventory.Item;
import components.plate.Plate;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;

public class CenterPane extends StackPane {
	private Plate plate;
	private Inventory inventory;

	public CenterPane(Inventory inventory) {
		setInventory(inventory);
		plate = Plate.getInstance();
		this.getChildren().add(plate);
		addClickEventListener();
	}
	
	/**
	 * Click event for using Items
	 */
	private void addClickEventListener() {
		this.addEventFilter(MouseEvent.ANY, new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				Node currentItem = inventory.getCurrentSlot().getItem();
				if (currentItem instanceof Item) {
					if (event.getEventType().equals(MouseEvent.MOUSE_PRESSED)) {
						((Item) currentItem).use();
					} else if (event.getEventType().equals(MouseEvent.MOUSE_RELEASED)) {
						((Item) currentItem).stop();
					}
				}
			}
		});
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

}
