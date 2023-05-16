package components.plate;

import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.canvas.*;

public class RowOfPaper extends StackPane {
	private static VBox vbox;
	private static double startDragY;
	private static double startDragX;
	private static double currentY;
	private static double currentX;
	Canvas rubber = new Canvas(12, 540);
	GraphicsContext gc = rubber.getGraphicsContext2D();

	public RowOfPaper() {
		this.setWidth(102);
		this.setHeight(600);

		gc.setStroke(Color.rgb(255, 196, 0));
		gc.setLineWidth(2);
		gc.strokeLine(2, 0, 2, 540);
		gc.strokeLine(10, 0, 10, 540);
		vbox = new VBox();
		for (int i = 0; i < 4; i++) {
			vbox.getChildren().add(new PaperBox());
		}
		vbox.setMaxWidth(getWidth());
		this.getChildren().add(vbox);
		RowOfPaper.setMargin(vbox, new Insets(10, 0, 0, 0));
		RowOfPaper.setAlignment(vbox, Pos.BOTTOM_CENTER);
		this.getChildren().add(rubber);
		RowOfPaper.setMargin(rubber, new Insets(0, 16, 0, 0));
		RowOfPaper.setAlignment(rubber, Pos.TOP_CENTER);

		final RowOfPaper _self = this;
		rubber.setOnMouseEntered(e -> {
			setCursor(Cursor.HAND);
		});
		rubber.setOnMouseExited(e -> {
			setCursor(Cursor.DEFAULT);
		});
//		rubber.setOnMouseClicked(e -> {
//			for (int i=0;i<4;i++) {
//				((Paper) ((PaperBox) (((VBox) _self.getChildren().get(0)).getChildren().get(i))).getChildren().get(1)).flipToPage(0);
//				((PaperAbove) ((PaperBox) (((VBox) _self.getChildren().get(0)).getChildren().get(i))).getChildren().get(0)).flipToPage(0);
//			}
//		
//		});
		rubber.setOnMouseDragged(e -> {
			System.out.println(e.getSceneY());
			currentX = Math.max(Math.min(e.getSceneX(), startDragX + 55), startDragX - 41);
			currentY = Math.max(Math.min(e.getSceneY()-88, 540), 0);

			drawLine(currentX - startDragX + 51 - 8, currentY);
		});
		rubber.setOnMousePressed(e -> {
			RowOfPaper.setMargin(rubber, new Insets(0, 0, 0, 0));
			rubber.setWidth(100);
			gc.clearRect(0, 0, rubber.getWidth(), rubber.getHeight());
			gc.strokeLine(38, 0, 38, 540);
			gc.strokeLine(46, 0, 46, 540);
			startDragY = e.getSceneY();
			startDragX = e.getSceneX();

		});
		rubber.setOnMouseReleased(e -> {
			gc.clearRect(0, 0, rubber.getWidth(), rubber.getHeight());
			RowOfPaper.setMargin(rubber, new Insets(0, 16, 0, 0));
			rubber.setWidth(12);
			gc.strokeLine(2, 0, 2, 540);
			gc.strokeLine(10, 0, 10, 540);
		});
	}

	public void drawLine(double X, double Y) {
		gc.clearRect(0, 0, rubber.getWidth(), rubber.getHeight());

		gc.strokeLine(38, 0, X, Y);
		gc.strokeLine(X, Y, 38, 540);
		gc.strokeLine(46, 0, X, Y);
		gc.strokeLine(X, Y, 46, 540);
		updateRow(X, Y);
	}

	public void updateRow(double X, double Y) {
		final RowOfPaper _self = this;
		for (int i = 0; i < 4; i++) {
			int yfromtop = 100 * i + 62;
			if (Y >= yfromtop && yfromtop * Math.abs(X - 45) / Y >= 35) {
				((Paper) ((PaperBox) (((VBox) _self.getChildren().get(0)).getChildren().get(i))).getChildren().get(1))
						.flipToPage(0);
				((PaperAbove) ((PaperBox) (((VBox) _self.getChildren().get(0)).getChildren().get(i))).getChildren()
						.get(0)).flipToPage(0);
			} else if (Y < yfromtop && (Y - yfromtop) * Math.abs(X - 45) / Y >= 35) {
				((Paper) ((PaperBox) (((VBox) _self.getChildren().get(0)).getChildren().get(i))).getChildren().get(1))
						.flipToPage(0);
				((PaperAbove) ((PaperBox) (((VBox) _self.getChildren().get(0)).getChildren().get(i))).getChildren()
						.get(0)).flipToPage(0);
			}
		}
	}
}
