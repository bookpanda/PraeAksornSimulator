package components.plate;

import javafx.geometry.Pos;
import javafx.scene.image.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

public class Plate extends StackPane {
	private static Plate plate = null;

	private Plate() {

		Image plateFrame = new Image("\\images\\plate-frame.png");

		ImageView frameview = new ImageView(plateFrame);
		GridPane gp = new GridPane();
//		for (int i = 0; i < 4; i++) {
//			for (int j = 0; j < 5; j++) {
//				PaperBox paperBox = new PaperBox();
//				gp.add(paperBox, j, i, 1, 1);
//			}
//		}

		for (int i = 0; i < 5; i++) {
			RowOfPaper rowofPaper = new RowOfPaper();
			gp.add(rowofPaper, i, 0);
		}
		gp.setAlignment(Pos.BOTTOM_CENTER);
		this.getChildren().add(frameview);
		StackPane.setAlignment(frameview, Pos.BOTTOM_CENTER);
		this.getChildren().add(gp);
		this.setAlignment(Pos.CENTER);
	}

	public static Plate getInstance() {
		if (plate == null) {
			plate = new Plate();
		}
		return plate;
	}
}
