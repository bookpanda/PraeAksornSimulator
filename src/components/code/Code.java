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
//		oshi_no_ko
		codes.add(new Pair<>(new int[][] { { 30, 18, 18, 23, 20 }, { 6, 28, 18, 23, 18 }, { 18, 28, 18, 18, 18 },
				{ 18, 28, 18, 18, 23 } }, "oshi_no_ko"));
//		kaokai
		codes.add(new Pair<>(new int[][] { { 12, 17, 24, 24, 24 }, { 17, 24, 24, 24, 24 }, { 24, 24, 24, 24, 24 },
				{ 24, 24, 24, 24, 24 } }, "oshi_no_ko"));
//		mao
		codes.add(new Pair<>(new int[][] { { 6, 6, 29, 6, 29 }, { 29, 29, 29, 29, 29 }, { 28, 28, 28, 28, 28 },
				{ 28, 28, 28, 28, 28 } }, "mao"));
		return codes;
	}

	public int getSize() {
		return codes.size();
	}
}
