package pane;

import components.inventory.Inventory;
import components.inventory.Item;
import components.plate.Plate;
import components.timer.Timer;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
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

	private RootPane() {
		BackgroundImage bi = new BackgroundImage(new Image("images/start_stand.png", 1000, 700, false, true),
				BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
				BackgroundSize.DEFAULT);
		this.setBackground(new Background(bi));
		Timer.getInstance();
		inventory = new Inventory();
		Plate plate = Plate.getInstance();
		TopPane topPane = new TopPane();
		BottomPane bottomPane = new BottomPane(inventory);
		this.setTop(topPane);
		this.setCenter(plate);
		this.setBottom(bottomPane);

		this.setOnScroll(new EventHandler<ScrollEvent>() {
			public void handle(ScrollEvent event) {
				double deltaY = event.getDeltaY();
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
		});

		this.addEventFilter(MouseEvent.ANY, new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				Node currentItem = inventory.getCurrentSlot().getItem();
				if (currentItem instanceof Item) {
					if (event.getEventType().equals(MouseEvent.MOUSE_PRESSED)) {
						((Item) currentItem).use();
					} else if (event.getEventType().equals(MouseEvent.MOUSE_RELEASED)) {
						((Item) currentItem).stop();
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
}
