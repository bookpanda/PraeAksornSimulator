package components.code;

import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.util.Pair;

public class Table extends GridPane {
	private String name;
	private int[][] code;

	public Table(Pair<int[][], String> code) {
		setName(code.getValue());
		setCode(code.getKey());
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 5; j++) {
				Text text = new Text(String.valueOf(this.code[i][j]));
				this.add(text, j, i);
			}
		}
		this.setHgap(5);
		this.setVgap(5);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int[][] getCode() {
		return code;
	}

	public void setCode(int[][] code) {
		this.code = code;
	}

}
