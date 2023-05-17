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
//		demon_slayer
		codes.add(new Pair<>(new int[][] { { 20, 24, 24, 20, 19 }, { 19, 19, 19, 19, 19 }, { 19, 19, 19, 19, 2 },
				{ 19, 18, 18, 27, 26 } }, "demon_slayer"));
//		jojo
		codes.add(new Pair<>(new int[][] { { 14, 14, 14, 14, 14 }, { 14, 14, 24, 24, 14 }, { 14, 9, 9, 14, 14 },
				{ 9, 14, 14, 14, 14 } }, "jojo"));
//		one_piece
		codes.add(new Pair<>(new int[][] { { 13, 13, 13, 13, 13 }, { 13, 13, 13, 13, 13 }, { 18, 13, 18, 18, 18 },
				{ 12, 18, 18, 1, 18 } }, "one_piece"));
//		attack_on_titan
		codes.add(new Pair<>(
				new int[][] { { 7, 7, 8, 8, 8 }, { 8, 8, 21, 8, 8 }, { 28, 28, 3, 3, 3 }, { 28, 28, 28, 28, 28 } },
				"attack_on_titan"));
//		test
		codes.add(new Pair<>(new int[][] { { 0, 0, 0, 0, 0 }, { 0, 1, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 } },
				"test"));
		return codes;
	}

	public int getSize() {
		return codes.size();
	}
}
