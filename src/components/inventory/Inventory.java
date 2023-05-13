package components.inventory;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.HBox;
import javafx.util.Pair;

public class Inventory extends HBox {
	private int index;
	private ArrayList<Pair<String, Boolean>> items;

	public Inventory() {
		this.setWidth(1000);
		this.setAlignment(Pos.CENTER);
		items = new ArrayList<Pair<String, Boolean>>();
		items.add(new Pair<>("plate", true));
		items.add(new Pair<>("paper", false));
		items.add(new Pair<>("water_bottle", false));// depends on time
		items.add(new Pair<>("food", false));// depends on flips

		for (Pair<String, Boolean> item : items) {
			this.getChildren().add(new Slot(item.getKey(), item.getValue()));
		}

	}
	public int getSize() {
		return items.size();
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
		int i = 0;
		for (Node item : this.getChildren()) {
			if (i != index)
				((Slot) item).setActive(false);
			else
				((Slot) item).setActive(true);
			i += 1;
		}
	}

}
