package components.code;

import java.util.ArrayList;

import javafx.util.Pair;

public class CodeWrapper {
	private int index;
	private ArrayList<Pair<int[][], String>> codes;
	private Code c = new Code();

	private static CodeWrapper codeWrapper = null;

	private CodeWrapper() {
		setCodes(c.main());
	}

	public static synchronized CodeWrapper getInstance() {
		if (codeWrapper == null)
			codeWrapper = new CodeWrapper();
		return codeWrapper;
	}

	public int getNewIndex() {
		if((Integer) index != null) {
			codes.remove(index);
		}
		int newIndex = (int) (Math.random() * c.getSize());
		setIndex(newIndex);
		return newIndex;
	}

	public int[][] getCurrentCode() {
		return codes.get(index).getKey();
	}

	public String getCurrentCodeName() {
		return codes.get(index).getValue();
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public void setCodes(ArrayList<Pair<int[][], String>> codes) {
		this.codes = codes;
	}

	public ArrayList<Pair<int[][], String>> getCodes() {
		return this.codes;
	}
}
