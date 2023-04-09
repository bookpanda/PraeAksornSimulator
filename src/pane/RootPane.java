package pane;


import components.PaperBox;
import javafx.geometry.Insets;
import javafx.scene.layout.BorderPane;

public class RootPane extends BorderPane {
	private static PaperBox paperbox;
	
	public RootPane() {
		paperbox = new PaperBox();
		this.setLeft(paperbox);
		this.setPadding(new Insets(1,1,1,1));
	}

	public static PaperBox getPaperBox() {
		return paperbox;
	}
}

