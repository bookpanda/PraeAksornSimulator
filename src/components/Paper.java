package components;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
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
		Button btn = new Button();
		btn.setText("Submit");

		final Paper _self = this;

		btn.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				System.out.println(page + 1);
				setPage(page + 1);
				text.setText(Integer.toString(page + 1));
				boolean flag = true;
				for (int a : textWhite) {
					System.out.println(a + " " + page);
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

		this.getChildren().addAll(text, btn);
	}

	public int getPage() {
		return page;
	}

	public void setPage(int number) {
		page = number % 30;
	}
}
