package components.plate;

import javafx.geometry.Pos;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class Paper extends PaperAbove {
	private int[] textWhite = { 1, 3, 5, 7, 8, 14, 18, 19, 20, 23, 24, 25, 26, 27, 28, 29 };
	Text text = new Text();

	public Paper() {
		this.setPrefHeight(50);
		this.setPrefWidth(100);
		this.setStyle("-fx-background-color: " + this.getColor() + ";");
		this.setSpacing(20);
		this.setAlignment(Pos.CENTER);
		text.setText(Integer.toString(this.getPage() + 1));
		text.setStyle("-fx-font: 25 arial;");
		this.getChildren().add(text);

	}

	public void flipToPage(int number) {
		super.flipToPage(number);
		text.setText(Integer.toString(this.getPage() + 1));
		boolean flag = true;
		for (int idx : textWhite) {
			if (idx == this.getPage()) {
				text.setFill(Color.WHITE);
				flag = false;
				break;
			}
		}
		if (flag)
			text.setFill(Color.BLACK);
	}
}
