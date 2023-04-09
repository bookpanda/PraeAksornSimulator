package components;

import java.util.ArrayList;

public class CodePaper {
	private int index;
	private ArrayList<int[][]> codes;
	private Code c = new Code();

	public CodePaper() {
		setCodes(c.main());
	}
	
	public int[][] getCurrentCode() {
		return codes.get(index);
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		if (index >= 0 && index < c.getSize())
			this.index = index;
	}

	public ArrayList<int[][]> getCodes() {
		return codes;
	}

	public void setCodes(ArrayList<int[][]> newCodes) {
		codes = newCodes;
	}
}
