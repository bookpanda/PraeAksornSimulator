package pane;

import components.Paper;
import javafx.scene.layout.BorderPane;

public class RootPane extends BorderPane {
	private static Paper paper;

	public RootPane() {
		paper = new Paper();
		this.setLeft(getPaper());
	}

	public static Paper getPaper() {
		return paper;
	}
}

