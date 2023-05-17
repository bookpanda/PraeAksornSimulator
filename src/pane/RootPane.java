package pane;

import components.inventory.Inventory;
import components.inventory.Item;
import components.plate.Plate;
import components.stats.HungerBar;
import components.stats.ThirstBar;
import components.timer.StartButton;
import components.timer.Timer;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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
import javafx.scene.layout.VBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class RootPane extends BorderPane {
	private static RootPane rootPane = null;
	private static Timer timer;
	private static Inventory inventory;

	private RootPane() {
		BackgroundImage bi = new BackgroundImage(new Image("images/start_stand.png", 1000, 700, false, true),
				BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
				BackgroundSize.DEFAULT);
		this.setBackground(new Background(bi));
		VBox controlsBox = new VBox();
		timer = Timer.getInstance();
		StartButton startButton = new StartButton();
		ScorePane scorePane = ScorePane.getInstance();
		controlsBox.getChildren().addAll(scorePane, timer, startButton);
		inventory = new Inventory();
		BorderPane.setMargin(inventory, new Insets(8, 0, 8, 0));
		Plate plate = Plate.getInstance();
		VBox statsBox = new VBox();
		statsBox.setPrefWidth(200);
		Text hungerText = new Text("Hunger");
		hungerText.setFont(Font.font(null, FontWeight.SEMI_BOLD, 16));
		HungerBar hungerBar = HungerBar.getInstance();
		Text thirstText = new Text("Thirst");
		thirstText.setFont(Font.font(null, FontWeight.SEMI_BOLD, 16));
		ThirstBar thirstBar = ThirstBar.getInstance();
		statsBox.getChildren().addAll(hungerText, hungerBar, thirstText, thirstBar);
		StackPane bottom = new StackPane();
		bottom.getChildren().addAll(statsBox, inventory);
		StackPane.setAlignment(inventory, Pos.CENTER);
		this.setTop(controlsBox);
		this.setCenter(plate);
		this.setBottom(bottom);

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
