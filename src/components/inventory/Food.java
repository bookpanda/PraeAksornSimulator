/**
 * Food item in Inventory
 */
package components.inventory;

import components.stats.HungerBar;
import components.stats.StatsBar;
import components.timer.Timer;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class Food extends HBox implements Item {
	private static Food food = null;
	private Thread thread;

	private Food() {
		Image image = new Image("images/items/food_active.png");
		ImageView imageView = new ImageView();
		imageView.setPreserveRatio(true);
		imageView.setRotate(-15);
		imageView.setFitHeight(400);
		imageView.setImage(image);
		imageView.setTranslateX(50);
		imageView.setTranslateY(400);
		this.getChildren().add(imageView);
	}

	/**
	 * Eating food runs a thread that will call HungerBar's replenish() 
	 */
	public void use() {
		Timer timer = Timer.getInstance();
		if (timer.isActive()) {
			HungerBar hungerBar = HungerBar.getInstance();
			UseRunnable useRunnable = new UseRunnable((StatsBar) hungerBar);
			thread = new Thread(useRunnable);
			thread.start();
		}
	}

	public void stop() {
		if (thread != null)
			thread.interrupt();
	}

	public static Food getInstance() {
		if (food == null) {
			food = new Food();
		}
		return food;
	}
}
