/**
 * Top part of RootPane (Timer, Score, CodeWrapper ,program routes)
 */
package pane;

import components.code.CodeWrapper;
import components.timer.ExitButton;
import components.timer.PauseButton;
import components.timer.StartButton;
import components.timer.Timer;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import score.Score;

public class TopPane extends HBox {
	private static Timer timer;
	private static Score score;
	private static CodeWrapper codeWrapper;

	public TopPane() {
		this.setMaxWidth(1000);
		this.getChildren().addAll(getInfoBox(), getButtonsBox());
		this.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, null, getInsets())));
		this.setAlignment(Pos.CENTER_LEFT);
	}

	private HBox getInfoBox() {
		score = Score.getInstance();
		timer = Timer.getInstance();
		codeWrapper = CodeWrapper.getInstance();
		HBox infoBox = new HBox();
		infoBox.setPrefWidth(500);
		infoBox.getChildren().addAll(score, timer, codeWrapper);
		HBox.setMargin(score, new Insets(10, 0, 10, 50));
		HBox.setMargin(timer, new Insets(10, 0, 10, 50));
		HBox.setMargin(codeWrapper, new Insets(10, 0, 10, 50));
		return infoBox;
	}

	private HBox getButtonsBox() {
		StartButton startButton = StartButton.getInstance();
		PauseButton pauseButton = PauseButton.getInstance();
		ExitButton exitButton = new ExitButton();
		HBox buttonsBox = new HBox();
		buttonsBox.setPrefWidth(500);
		buttonsBox.getChildren().addAll(startButton, pauseButton, exitButton);
		HBox.setMargin(startButton, new Insets(10, 0, 10, 50));
		HBox.setMargin(pauseButton, new Insets(10, 0, 10, 50));
		HBox.setMargin(exitButton, new Insets(10, 0, 10, 50));
		return buttonsBox;
	}

}
