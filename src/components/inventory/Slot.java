package components.inventory;

import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

public class Slot extends StackPane {
	private String item;
	private boolean active;

	public Slot(String item, boolean active) {
		this.setPrefHeight(70);
		this.setPrefWidth(70);
		// this.getChildren().add(item);
		this.setActive(active);
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
		Color color;
		if (active) {
			color = Color.GRAY;
		} else {
			color = Color.LIGHTGRAY;
		}
		this.setBorder(new Border(
				new BorderStroke(color, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
	}
}
