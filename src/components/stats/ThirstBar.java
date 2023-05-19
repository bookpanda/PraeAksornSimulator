/**
 * Displays thirst bar and controls thirst level
 */
package components.stats;

import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class ThirstBar extends StatsBar {
	private static ThirstBar thirstBar = null;
	private int thirst = 200;
	private Text text;

	private ThirstBar() {
		this.text = new Text(String.valueOf(thirst));
		this.getChildren().add(this.text);
		this.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, null, null)));
	}

	public static ThirstBar getInstance() {
		if (thirstBar == null)
			thirstBar = new ThirstBar();
		return thirstBar;
	}

	/**
	 * Updates both the display and actual value
	 */
	public void replenish() {
		this.setStats(Math.max(0, Math.min(200, thirst + 10)));
		this.setWidth(Math.max(0, Math.min(200, thirst + 10)));
	}

	public int getStats() {
		return thirst;
	}

	public void setStats(int thirst) {
		this.thirst = thirst;
		this.text.setText(String.valueOf(thirst));
	}

	public String getName() {
		return "thirst";
	}

}
