/**
 * Wrapper class for Code in order to make use of Code class
 */
package components.code;

import java.util.ArrayList;

import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Pair;

public class CodeWrapper extends VBox {
	private int index;
	private ArrayList<Pair<int[][], Pair<String, String>>> codes;
	private Code code = new Code();
	private Text codeText;
	private Text couText;
	private static CodeWrapper codeWrapper = null;

	/**
	 * Also has display for the current code in game play
	 */
	private CodeWrapper() {
		setCodes(code.main());
		couText = new Text("Code: ");
		couText.setFont(new Font(null, 20));
		codeText = new Text();
		codeText.setFont(new Font(null, 20));
		this.getChildren().addAll(couText, codeText);
	}

	public static synchronized CodeWrapper getInstance() {
		if (codeWrapper == null)
			codeWrapper = new CodeWrapper();
		return codeWrapper;
	}

	/**
	 * Changes current code (also delete previous code so that no same code will
	 * occur twice while playing)
	 */
	public int getNewIndex() {
		if ((Integer) index != null) {
			codes.remove(index);
		}
		int newIndex = (int) (Math.random() * code.getSize());
		setIndex(newIndex);
		codeText.setText(getCurrentDisplayName());
		return newIndex;
	}

	public void reset() {
		setCodes(code.main());
	}

	public int[][] getCurrentCode() {
		return codes.get(index).getKey();
	}

	/**
	 * Code name is used to navigate to image and music files of that specific code
	 */
	public String getCurrentCodeName() {
		return codes.get(index).getValue().getKey();
	}

	/**
	 * Display name is what is shown to user
	 */
	public String getCurrentDisplayName() {
		return codes.get(index).getValue().getValue();
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	/**
	 * Updates the current round on the game e.g. round 1/5, round 4/5
	 */
	public void setCou(int cou, int totalCou) {
		couText.setText("Code: (" + cou + "/" + totalCou + ")");
	}

	public void setCodes(ArrayList<Pair<int[][], Pair<String, String>>> codes) {
		this.codes = codes;
	}

	public ArrayList<Pair<int[][], Pair<String, String>>> getCodes() {
		return this.codes;
	}
}
