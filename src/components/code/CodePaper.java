package components.code;

import java.util.ArrayList;

import javafx.util.Pair;

public class CodePaper {
	private int index;
	private ArrayList<Pair<int[][], String>> codes;
	private Code c = new Code();

	public CodePaper() {
		setCodes(c.main());
	}

	public int[][] getCurrentCode() {
		return codes.get(index).getKey();
	}

	public String getCurrentImage() {
		return codes.get(index).getValue();
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		if (index >= 0 && index < c.getSize())
			this.index = index;
	}

	public ArrayList<Pair<int[][], String>> getCodes() {
		return codes;
	}

	public void setCodes(ArrayList<Pair<int[][], String>> newCodes) {
		codes = newCodes;
	}
}
