package components.plate;

import javafx.geometry.Pos;
import javafx.scene.layout.HBox;

public class PaperAbove extends HBox {
	private String[] colors = { "#B59B7C", "#ffffff", "#4f76af", "#a6d5ff", "#404fff", "#8cb01b", "#36211d", "#90795a", "#6e3b2e",
			"#9c4a18", "#b67b42", "#cc9c8f", "#d8a8a2", "#d2cc66", "#cfaf27", "#437735", "#9aa260", "#ffa74e",
			"#fff2cf", "#bb222d", "#d85978", "#692934", "#d578b1", "#cf9cbd", "#da4c0a", "#761f8a", "#a76db7",
			"#9c0e0e", "#676f71", "#3b3c34", "#000000", "#B59B7C" };
	private int page = 0;

	public PaperAbove() {
		this.setPrefHeight(50);
		this.setPrefWidth(100);
		this.setStyle("-fx-background-color: " + this.getColor() + ";");
		this.setSpacing(20);
		this.setAlignment(Pos.CENTER);
		this.setVisible(false);
	}
	
	public void flipToPage(int number) {
		setPage(number);
		this.setStyle("-fx-background-color: " + this.getColor() + ";");
		if (number <= 0) {
			this.setVisible(false);
		}else {
			this.setVisible(true);
		}
	}

	public void setPage(int number) {
		number = Math.max(0, number);
		number = Math.min(31, number);
		page = number;
	}

	public int getPage() {
		return page;
	}
	public String getText() {
		if (page == 0)return "";
		if (page == 31)return "";
		return ""+page+"";
	}
	public String getColor() {
		return colors[page];
	}
}
