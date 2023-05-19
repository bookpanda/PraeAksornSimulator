/**
 * also known as "Kradak Tak" in real life, displays the instructions for each code
 */
package components.code;

import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.util.Pair;

public class CodePaper extends GridPane {
	private static CodePaper codePaper = null;
	private CodeWrapper codeWrapper = CodeWrapper.getInstance();

	/**
	 * CodePaper is made of VBoxes, each VBox is code's name followed by
	 * instructions (as an instance of Table class)
	 */
	private CodePaper() {
		ArrayList<Pair<int[][], Pair<String, String>>> codes = codeWrapper.getCodes();
		int cou = 0;
		for (Pair<int[][], Pair<String, String>> code : codes) {
			VBox vb = new VBox();
			Text text = new Text(code.getValue().getValue());
			vb.getChildren().addAll(text, new Table(code));
			this.add(vb, cou / 3, cou % 3);
			GridPane.setMargin(vb, new Insets(10, 10, 10, 10));
			cou += 1;
		}
		this.setAlignment(Pos.CENTER);
		this.setMinWidth(500);
		this.setMaxWidth(500);
		this.setMaxHeight(500);
		this.setBackground(new Background(new BackgroundFill(Color.WHITESMOKE, null, null)));
	}

	public static CodePaper getInstance() {
		if (codePaper == null)
			codePaper = new CodePaper();
		return codePaper;
	}
}
