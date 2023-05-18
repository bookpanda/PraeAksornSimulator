package components.code;

import java.util.ArrayList;

import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Pair;

public class CodeWrapper extends VBox {
	private int index;
	private ArrayList<Pair<int[][], Pair<String, String>>> codes;
	private Code c = new Code();
	private Text codeText;
	private static CodeWrapper codeWrapper = null;

	private CodeWrapper() {
		setCodes(c.main());
		Text text = new Text("Code: ");
		text.setFont(new Font(null, 20));
		codeText = new Text();
		codeText.setFont(new Font(null, 20));
		this.getChildren().addAll(text, codeText);
	}

	public static synchronized CodeWrapper getInstance() {
		if (codeWrapper == null)
			codeWrapper = new CodeWrapper();
		return codeWrapper;
	}

	public int getNewIndex() {
		if ((Integer) index != null) {
			codes.remove(index);
		}
		int newIndex = (int) (Math.random() * c.getSize());
		setIndex(newIndex);
		codeText.setText(getCurrentDisplayName());
		return newIndex;
	}

	public void reset() {
		setCodes(c.main());
	}

	public int[][] getCurrentCode() {
		return codes.get(index).getKey();
	}

	public String getCurrentCodeName() {
		return codes.get(index).getValue().getKey();
	}

	public String getCurrentDisplayName() {
		return codes.get(index).getValue().getValue();
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public void setCodes(ArrayList<Pair<int[][], Pair<String, String>>> codes) {
		this.codes = codes;
	}

	public ArrayList<Pair<int[][], Pair<String, String>>> getCodes() {
		return this.codes;
	}
}
