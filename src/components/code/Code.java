package components.code;

import java.util.ArrayList;

import javafx.util.Pair;

public class Code {
	private ArrayList<Pair<int[][], String>> codes = new ArrayList<Pair<int[][], String>>();

	public ArrayList<Pair<int[][], String>> main() {
//		kessoku
		codes.add(new Pair<>(new int[][] { { 23, 23, 23, 22, 22 }, { 26, 23, 23, 22, 22 }, { 26, 23, 23, 22, 22 },
				{ 23, 23, 23, 22, 22 } }, "kessoku"));
//		amogus
		codes.add(new Pair<>(
				new int[][] { { 30, 30, 6, 29, 4 }, { 29, 29, 4, 4, 2 }, { 4, 4, 29, 4, 2 }, { 29, 25, 25, 29, 29 } },
				"amogus"));
		return codes;
	}

	public int getSize() {
		return codes.size();
	}
}
