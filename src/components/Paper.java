package components;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class Paper extends HBox {
	private String[] colors = { "#ffffff", "#4f76af", "#a6d5ff", "#404fff", "#8cb01b", "#36211d", "#90795a", "#6e3b2e",
			"#9c4a18", "#b67b42", "#cc9c8f", "#d8a8a2", "#d2cc66", "#cfaf27", "#437735", "#9aa260", "#ffa74e",
			"#fff2cf", "#bb222d", "#d85978", "#692934", "#d578b1", "#cf9cbd", "#da4c0a", "#761f8a", "#a76db7",
			"#9c0e0e", "#676f71", "#3b3c34", "#000000" };
	private int[] textWhite = { 1, 3, 5, 7, 8, 14, 18, 19, 20, 23, 24, 25, 26, 27, 28, 29 };
	private int page = 0;

	public Paper() {
		this.setPrefHeight(70);
		this.setPrefWidth(100);
		this.setStyle("-fx-background-color: " + colors[page] + ";");
		this.setSpacing(20);
		this.setAlignment(Pos.CENTER);
		final Text text = new Text();
		text.setText(Integer.toString(page + 1));
		text.setStyle("-fx-font: 25 arial;");

		final Paper _self = this;
		this.setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				int multiplier = 1;
				if (event.isShiftDown()) {
					multiplier = (int) (Math.random() * 3 + 3);
				} else if (event.isControlDown()) {
					multiplier = (int) (Math.random() * 4 + 7);
				}
				if (event.getButton().equals(MouseButton.SECONDARY)) {
					setPage(page - multiplier);

				} else {
					setPage(page + multiplier);
				}
				text.setText(Integer.toString(page + 1));

				boolean flag = true;
				for (int a : textWhite) {
					if (a == page) {
						text.setFill(Color.WHITE);
						flag = false;
						break;
					}
				}
				if (flag)
					text.setFill(Color.BLACK);
				_self.setStyle("-fx-background-color: " + colors[page] + ";");
			}
		});

		this.getChildren().add(text);
	}

	public int getPage() {
		return page;
	}

	public void setPage(int number) {
		number = Math.max(0, number);
		number = Math.min(29, number);
		page = number;
	}

}
