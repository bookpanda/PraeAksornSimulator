/**
 * Plate is 5 ColumnOfPapers (Each ColumnOfPaper is made of 4 PaperBoxes)
 */
package components.plate;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.image.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class Plate extends StackPane {
	private static Plate plate = null;

	private Plate() {
		Image plateFrame = new Image("images/plate_frame.png");
		ImageView frameview = new ImageView(plateFrame);
		GridPane gp = new GridPane();
		for (int i = 0; i < 5; i++) {
			ColumnOfPaper rowofPaper = new ColumnOfPaper();
			gp.add(rowofPaper, i, 0);
		}
		gp.setAlignment(Pos.CENTER);
		this.getChildren().add(frameview);
		StackPane.setAlignment(frameview, Pos.CENTER);
		this.getChildren().add(gp);
		this.setAlignment(Pos.CENTER);
	}

	public static Plate getInstance() {
		if (plate == null) {
			plate = new Plate();
		}
		return plate;
	}

	/**
	 * Resets every Paper and PaperAbove in each PaperBox to 0
	 */
	public void reset() {
		GridPane gp = (GridPane) this.getChildren().get(1);
		for (Node node : gp.getChildren()) {
			int row = 0;
			ColumnOfPaper rop = (ColumnOfPaper) node; // 4 paper
			VBox vbox = (VBox) rop.getChildren().get(0);
			for (Node n : vbox.getChildren()) {
				if (row > 3)
					break;
				PaperBox pb = (PaperBox) n;
				PaperAbove pa = (PaperAbove) pb.getChildren().get(0);
				pa.flipToPage(0);
				Paper p = (Paper) pb.getChildren().get(1);
				p.flipToPage(0);
				row += 1;
			}
		}
	}
}
