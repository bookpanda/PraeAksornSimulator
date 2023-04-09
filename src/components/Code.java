package components;

import java.util.ArrayList;

public class Code {
	private ArrayList<int[][]> codes = new ArrayList<int[][]>();
	public ArrayList<int[][]> main() {
		codes.add(new int[][] { { 18, 18, 18, 18, 23 }, { 18, 18, 18, 18, 18 }, { 18, 18, 18, 18, 18 },
				{ 18, 18, 18, 18, 18 } });
		return codes;
	}
	public int getSize() {
		return codes.size();
	}
}
