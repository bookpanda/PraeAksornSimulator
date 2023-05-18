package components.code;

import java.util.ArrayList;

import javafx.util.Pair;

public class Code {
	private ArrayList<Pair<int[][], Pair<String, String>>> codes;

	public ArrayList<Pair<int[][], Pair<String, String>>> main() {
		codes = new ArrayList<Pair<int[][], Pair<String, String>>>();
//		kessoku
		codes.add(new Pair<>(new int[][] { { 23, 23, 23, 22, 22 }, { 26, 23, 23, 22, 22 }, { 26, 23, 23, 22, 22 },
				{ 23, 23, 23, 22, 22 } }, new Pair<>("kessoku", "Kessoku")));
//		amogus
		codes.add(new Pair<>(
				new int[][] { { 30, 30, 6, 29, 4 }, { 29, 29, 4, 4, 2 }, { 4, 4, 29, 4, 2 }, { 29, 25, 25, 29, 29 } },
				new Pair<>("amogus", "Amogus")));
//		oshi_no_ko
		codes.add(new Pair<>(new int[][] { { 30, 18, 18, 23, 20 }, { 6, 28, 18, 23, 18 }, { 18, 28, 18, 18, 18 },
				{ 18, 28, 18, 18, 23 } }, new Pair<>("oshi_no_ko", "Oshi No Ko")));
//		demon_slayer
		codes.add(new Pair<>(new int[][] { { 20, 24, 24, 20, 19 }, { 19, 19, 19, 19, 19 }, { 19, 19, 19, 19, 2 },
				{ 19, 18, 18, 27, 26 } }, new Pair<>("demon_slayer", "Demon Slayer")));
//		jojo
		codes.add(new Pair<>(new int[][] { { 14, 14, 14, 14, 14 }, { 14, 14, 24, 24, 14 }, { 14, 9, 9, 14, 14 },
				{ 9, 14, 14, 14, 14 } }, new Pair<>("jojo", "Jojo")));
//		one_piece
		codes.add(new Pair<>(new int[][] { { 13, 13, 13, 13, 13 }, { 13, 13, 13, 13, 13 }, { 18, 13, 18, 18, 18 },
				{ 12, 18, 18, 1, 18 } }, new Pair<>("one_piece", "One Piece")));
//		attack_on_titan
		codes.add(new Pair<>(
				new int[][] { { 7, 7, 8, 8, 8 }, { 8, 8, 21, 8, 8 }, { 28, 28, 3, 3, 3 }, { 28, 28, 28, 28, 28 } },
				new Pair<>("attack_on_titan", "Attack On Titan")));
//		test
		codes.add(new Pair<>(new int[][] { { 0, 0, 0, 0, 0 }, { 0, 1, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 } },
				new Pair<>("test", "Test")));
		return codes;
	}

	public int getSize() {
		return codes.size();
	}
}
