package components.inventory;

import components.stats.StatsBar;
import components.stats.ThirstBar;
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
		imageView.setFitHeight(400);
		imageView.setImage(image);
		imageView.setTranslateX(-80);
		imageView.setTranslateY(330);
		this.getChildren().add(imageView);
	}

	public void use() {
		ThirstBar thirstBar = ThirstBar.getInstance();
		UseRunnable ur = new UseRunnable((StatsBar) thirstBar);
		thread = new Thread(ur);
		thread.start();
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
