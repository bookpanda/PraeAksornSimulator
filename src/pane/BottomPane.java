package pane;

import java.awt.Color;

import components.inventory.Inventory;
import components.stats.HungerBar;
import components.stats.ThirstBar;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class BottomPane extends StackPane {
	private static Inventory inventory;

	public BottomPane(Inventory inv) {
		inventory = inv;
		Paint bgcolor = Paint.valueOf("lightgrey");
		this.setBackground(new Background(new BackgroundFill(bgcolor, CornerRadii.EMPTY, getInsets())));
		VBox statsBox = new VBox();
		statsBox.setPrefWidth(200);
		Text hungerText = new Text("Hunger");
		hungerText.setFont(Font.font(null, FontWeight.SEMI_BOLD, 16));
		HungerBar hungerBar = HungerBar.getInstance();
		Text thirstText = new Text("Thirst");
		thirstText.setFont(Font.font(null, FontWeight.SEMI_BOLD, 16));
		ThirstBar thirstBar = ThirstBar.getInstance();
		statsBox.getChildren().addAll(hungerText, hungerBar, thirstText, thirstBar);

		this.getChildren().addAll(statsBox, inventory);
		StackPane.setAlignment(inventory, Pos.CENTER);
	}
}
