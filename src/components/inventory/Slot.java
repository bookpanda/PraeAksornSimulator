package components.inventory;

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
	private String item;
	private boolean active;

	public Slot(String item, boolean active) {
		this.setPrefHeight(80);
		this.setPrefWidth(80);
		Image image = new Image("images/items/" + item + ".png");
		ImageView imageView = new ImageView();
		imageView.setImage(image);
		this.getChildren().add(imageView);
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
}
