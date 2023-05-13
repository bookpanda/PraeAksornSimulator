package components.inventory;

import java.util.ArrayList;

import javafx.geometry.Pos;
import javafx.scene.layout.HBox;

public class Inventory extends HBox {
	private int index;

	public Inventory() {
		this.setWidth(800);
		this.setAlignment(Pos.CENTER);
		ArrayList<String> items = new ArrayList<String>();
		items.add("plate");
		items.add("paper");
		items.add("water"); // depends on time
		items.add("food"); // depends on flips

		for (String item : items) {
			this.getChildren().add(new Slot(item));
		}
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

}
