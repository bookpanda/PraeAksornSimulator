package components.plate;

import javafx.geometry.Insets;
import javafx.scene.layout.VBox;

public class PaperBox extends VBox {
	private double startDragY;
	private static Paper paper;
	private static PaperAbove paperAbove;

	public PaperBox() {
		this.setSpacing(1);
		this.setPadding(new Insets(1, 1, 1, 1));
		paper = new Paper();
		paperAbove = new PaperAbove();
		this.getChildren().addAll(paperAbove, paper);
		final PaperBox _self = this;

		this.setOnMousePressed(e -> {
			startDragY = e.getSceneY();
		});

		this.setOnMouseReleased(e -> {
			int multiplier = 1;
			if (e.isShiftDown()) {
				multiplier = (int) (Math.random() * 3 + 3);
			} else if (e.isControlDown()) {
				multiplier = (int) (Math.random() * 4 + 7);
			}
			PaperAbove pa = (PaperAbove) _self.getChildren().get(0);
			Paper p = (Paper) _self.getChildren().get(1);
			double Y = e.getSceneY();
//			flip paper up
			if (Y - startDragY <= -30) {
				int newPageNumber = p.getPage() + multiplier;
//				System.out.println("Current Page = " + newPageNumber);
				p.flipToPage(newPageNumber);
				pa.flipToPage(newPageNumber);
//			flip paper down
			} else if (Y - startDragY >= 30) {
				int newPageNumber = p.getPage() - multiplier;
//				System.out.println("Current Page = " + newPageNumber);
				p.flipToPage(newPageNumber);
				pa.flipToPage(newPageNumber);
			}
		});
	}
	
}
