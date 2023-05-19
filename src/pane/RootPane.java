/**
 * Main pane for game play
 */
package pane;

import components.inventory.Inventory;
import components.timer.Timer;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;

public class RootPane extends BorderPane {
	private static RootPane rootPane = null;
	private static Inventory inventory;
	private CenterPane centerPane;

	private RootPane() {
		BackgroundImage bi = new BackgroundImage(new Image("images/start_stand.png", 1000, 700, false, true),
				BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
				BackgroundSize.DEFAULT);
		this.setBackground(new Background(bi));
		inventory = new Inventory();
		TopPane topPane = new TopPane();
		centerPane = new CenterPane(inventory);
		BottomPane bottomPane = new BottomPane(inventory);
		this.setTop(topPane);
		this.setCenter(centerPane);
		this.setBottom(bottomPane);
		setOnScroll();
	}

	/**
	 * Scroll event for changing Slots in Inventory
	 */
	private void setOnScroll() {
		this.setOnScroll(new EventHandler<ScrollEvent>() {
			public void handle(ScrollEvent event) {
				double deltaY = event.getDeltaY();
				Timer timer = Timer.getInstance();
				if (timer.isActive()) {
					if (deltaY > 0) {
						int newIdx = inventory.getIndex() - 1;
						if (newIdx < 0)
							inventory.setIndex(inventory.getSize() - 1);
						else
							inventory.setIndex(newIdx);
					} else if (deltaY < 0) {
						int newIdx = inventory.getIndex() + 1;
						if (newIdx >= inventory.getSize())
							inventory.setIndex(0);
						else
							inventory.setIndex(newIdx);
					}
				}
			}
		});
	}

	public static synchronized RootPane getInstance() {
		if (rootPane == null)
			rootPane = new RootPane();
		return rootPane;
	}

	public CenterPane getCenterPane() {
		return centerPane;
	}
}
