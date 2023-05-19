/**
 * Water bottle item in Inventory
 */
package components.inventory;

import components.stats.StatsBar;
import components.stats.ThirstBar;
import components.timer.Timer;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class WaterBottle extends HBox implements Item {
	private static WaterBottle waterBottle = null;
	private Thread thread;

	private WaterBottle() {
		Image image = new Image("images/items/water_bottle_active.png");
		ImageView imageView = new ImageView();
		imageView.setPreserveRatio(true);
		imageView.setRotate(-15);
		imageView.setFitHeight(350);
		imageView.setImage(image);
		imageView.setTranslateX(-80);
		imageView.setTranslateY(430);
		this.getChildren().add(imageView);
	}

	/**
	 * Drinking water runs a thread that will call ThirstBar's replenish() 
	 */
	public void use() {
		Timer timer = Timer.getInstance();
		if (timer.isActive()) {
			ThirstBar thirstBar = ThirstBar.getInstance();
			UseRunnable useRunnable = new UseRunnable((StatsBar) thirstBar);
			thread = new Thread(useRunnable);
			thread.start();
		}
	}

	public void stop() {
		if (thread != null)
			thread.interrupt();
	}

	public static WaterBottle getInstance() {
		if (waterBottle == null) {
			waterBottle = new WaterBottle();
		}
		return waterBottle;
	}
}
