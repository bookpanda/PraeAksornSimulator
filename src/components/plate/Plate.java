package components.plate;

import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;

public class Plate extends GridPane {
	public Plate() {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 5; j++) {
				PaperBox paperBox = new PaperBox();
				this.add(paperBox, j, i, 1, 1);
			}
		}
		this.setAlignment(Pos.CENTER);
	}
}
