/**
 * Each slot in Inventory
 */
package components.inventory;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

public class Slot extends StackPane {
	private Node item;
	private String itemName;
	private boolean isActive;
	private String pos;

	/**
	 * Loads item into Slot
	 */
	public Slot(Node item, String itemName, boolean active, String pos) {
		this.setPrefHeight(60);
		this.setPrefWidth(60);
		Image image = new Image("images/items/" + itemName + ".png");
		ImageView imageView = new ImageView();
		imageView.setImage(image);
		this.getChildren().add(imageView);
		this.setActive(active);
		this.setPos(pos);
		this.setItemName(itemName);
		this.setItem(item);
	}

	public Node getItem() {
		return item;
	}

	public void setItem(Node item) {
		this.item = item;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public boolean isActive() {
		return isActive;
	}

	/**
	 * Highlights active item 
	 */
	public void setActive(boolean active) {
		this.isActive = active;
		Color borderColor;
		Color bgColor;
		if (active) {
			bgColor = Color.GRAY;
			borderColor = Color.DARKGRAY;
		} else {
			bgColor = Color.LIGHTGRAY;
			borderColor = Color.GRAY;
		}
		this.setBackground(new Background(new BackgroundFill(bgColor, null, getInsets())));
		this.setBorder(new Border(
				new BorderStroke(borderColor, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
	}

	public void setPos(String pos) {
		this.pos = pos;
	}

	public String getPos() {
		return this.pos;
	}
}
