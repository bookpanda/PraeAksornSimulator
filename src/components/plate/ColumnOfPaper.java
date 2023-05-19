/**
 * Made of 4 vertically aligned PaperBoxes
 */
package components.plate;

import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.canvas.*;

public class ColumnOfPaper extends StackPane {
	private static VBox vbox;
	private static double startDragX;
	private static double currentY;
	private static double currentX;
	private Canvas rubber = new Canvas(12, 540);
	private GraphicsContext gc = rubber.getGraphicsContext2D();

	public ColumnOfPaper() {
		this.setWidth(102);
		this.setHeight(600);

		gc.setStroke(Color.rgb(255, 196, 0));
		gc.setLineWidth(2);
		gc.strokeLine(2, 13, 2, 540);
		gc.strokeLine(10, 13, 10, 540);
		vbox = new VBox();
		for (int i = 0; i < 4; i++) {
			vbox.getChildren().add(new PaperBox());
		}
		vbox.setMaxWidth(getWidth());
		this.getChildren().add(vbox);
		ColumnOfPaper.setMargin(vbox, new Insets(10, 0, 0, 0));
		ColumnOfPaper.setAlignment(vbox, Pos.BOTTOM_CENTER);
		this.getChildren().add(rubber);
		ColumnOfPaper.setMargin(rubber, new Insets(0, 16, 0, 0));
		ColumnOfPaper.setAlignment(rubber, Pos.TOP_CENTER);

		@SuppressWarnings("unused")
		final ColumnOfPaper _self = this;
		setUpRubber();
	}

	/**
	 * Event listeners for rubber bands on the each ColumnOfPaper. Drag-clicking
	 * rubber can reset the Paper and PaperAbove in each PaperBox
	 */
	public void setUpRubber() {
		rubber.setOnMouseEntered(e -> {
			setCursor(Cursor.HAND);
		});
		rubber.setOnMouseExited(e -> {
			setCursor(Cursor.DEFAULT);
		});

		rubber.setOnMouseDragged(e -> {
			currentX = Math.max(Math.min(e.getSceneX(), startDragX + 55), startDragX - 41);
			currentY = Math.max(Math.min(e.getSceneY() - 88, 540), 0);

			drawLine(currentX - startDragX + 51 - 8, currentY);
		});
		rubber.setOnMousePressed(e -> {
			ColumnOfPaper.setMargin(rubber, new Insets(0, 0, 0, 0));
			rubber.setWidth(100);
			gc.clearRect(0, 0, rubber.getWidth(), rubber.getHeight());
			gc.strokeLine(38, 13, 38, 540);
			gc.strokeLine(46, 13, 46, 540);
			gc.strokeLine(38, 13, 38, 540);
			gc.strokeLine(46, 13, 46, 540);
			startDragX = e.getSceneX();

		});
		rubber.setOnMouseReleased(e -> {
			gc.clearRect(0, 0, rubber.getWidth(), rubber.getHeight());
			ColumnOfPaper.setMargin(rubber, new Insets(0, 16, 0, 0));
			rubber.setWidth(12);
			gc.strokeLine(2, 13, 2, 540);
			gc.strokeLine(10, 13, 10, 540);
		});
	}

	public void drawLine(double X, double Y) {
		gc.clearRect(0, 0, rubber.getWidth(), rubber.getHeight());

		gc.strokeLine(38, 13, X, Y);
		gc.strokeLine(X, Y, 38, 540);
		gc.strokeLine(46, 13, X, Y);
		gc.strokeLine(X, Y, 46, 540);
		updateColumn(X, Y);
	}

	/**
	 * When rubber band is dragged far enough, Paper and PaperAbove in PaperBox will
	 * be reset
	 */
	public void updateColumn(double X, double Y) {
		final ColumnOfPaper _self = this;
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
