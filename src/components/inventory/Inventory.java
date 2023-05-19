/**
 * Inventory is comprised of Slots that are filled with specific items
 */
package components.inventory;

import components.code.CodePaper;
import components.plate.Plate;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import pane.RootPane;

public class Inventory extends HBox {
	private int index;

	/**
	 * Loads items into Inventory (Plate and CodePaper are items in other packages)
	 */
	public Inventory() {
		this.setWidth(1000);
		this.setAlignment(Pos.CENTER);
		Plate plate = Plate.getInstance();
		CodePaper codePaper = CodePaper.getInstance();
		WaterBottle waterBottle = WaterBottle.getInstance();
		Food food = Food.getInstance();
		this.getChildren().add(new Slot(plate, "plate", true, "center"));
		this.getChildren().add(new Slot(codePaper, "paper", false, "center"));
		this.getChildren().add(new Slot(waterBottle, "water_bottle", false, "right"));
		this.getChildren().add(new Slot(food, "food", false, "right"));
	}

	public Slot getCurrentSlot() {
		return ((Slot) this.getChildren().get(this.index));
	}

	public int getSize() {
		return this.getChildren().size();
	}

	public int getIndex() {
		return index;
	}

	/**
	 * Change Inventory's current slot, Food and WaterBottle are displayed as being
	 * held by right hand, while Plate and CodePaper is displayed in the center
	 */
	public void setIndex(int index) {
		RootPane rootPane = RootPane.getInstance();
		Slot prevSlot = ((Slot) this.getChildren().get(this.index));
		prevSlot.setActive(false);
		if (prevSlot.getPos() == "center") {
			rootPane.setCenter(null);
		} else if (prevSlot.getPos() == "right") {
			rootPane.setRight(null);
		}
		this.index = index;
		Slot newSlot = ((Slot) this.getChildren().get(this.index));
		newSlot.setActive(true);
		if (newSlot.getPos() == "center") {
			rootPane.setCenter(newSlot.getItem());
		} else if (newSlot.getPos() == "right") {
			rootPane.setRight(newSlot.getItem());
		}
	}

}
