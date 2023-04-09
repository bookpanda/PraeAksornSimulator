package components;

import application.Main;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;

public class Plate extends GridPane {
	public Plate() {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 5; j++) {
				Paper paper = new Paper();
				this.add(paper, j, i, 1, 1);
			}
		}
		this.setAlignment(Pos.CENTER);
	}

	public boolean check() {
		for (Node node : this.getChildren()) {
			int row = this.getRowIndex(node);
			int col = this.getColumnIndex(node);
//			Main.;
			if (((Paper) node).getPage() != 1)
				return false;
		}
		return true;
	}
}
