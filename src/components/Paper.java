package components;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

public class Paper extends HBox {
	private int page;
	public Paper() {
		this.setPrefHeight(70);
		this.setPrefWidth(100);
//		this.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
		this.setStyle("-fx-background-color: " + "#000000" + ";");
		this.setSpacing(20);
		this.setAlignment(Pos.CENTER);
		final TextField tf = new TextField();
		tf.setPrefWidth(300);
		Button btn = new Button();
		btn.setText("Submit");
	}
}
