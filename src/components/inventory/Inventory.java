package components.inventory;

import java.util.ArrayList;

import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.util.Pair;

public class Inventory extends HBox {
	private int index;

	public Inventory() {
		this.setWidth(1000);
		this.setAlignment(Pos.CENTER);
		ArrayList<Pair<String, Boolean>> items = new ArrayList<Pair<String, Boolean>>();
		items.add(new Pair<>("plate", true));
		items.add(new Pair<>("paper", false));
		items.add(new Pair<>("water", false));// depends on time
		items.add(new Pair<>("food", true));// depends on flips
	

		for (Pair<String, Boolean> item : items) {
			this.getChildren().add(new Slot(item.getKey(), item.getValue()));
		}
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

}
