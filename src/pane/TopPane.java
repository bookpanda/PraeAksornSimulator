package pane;

import components.timer.ExitButton;
import components.timer.PauseButton;
import components.timer.StartButton;
import components.timer.Timer;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import score.Score;

public class TopPane extends HBox {
	private static Timer timer;
	private static Score score;

	public TopPane() {
		score = Score.getInstance();
		timer = Timer.getInstance();

		this.setMaxWidth(1000);
		StartButton startButton = StartButton.getInstance();
		PauseButton pauseButton = PauseButton.getInstance();
		ExitButton exitButton = new ExitButton();
		HBox buttonsBox = new HBox();
		buttonsBox.setPrefWidth(500);
		buttonsBox.getChildren().addAll(startButton, pauseButton, exitButton);
		HBox.setMargin(startButton, new Insets(10, 0, 0, 50));
		HBox.setMargin(pauseButton, new Insets(10, 0, 0, 50));
		HBox.setMargin(exitButton, new Insets(10, 0, 0, 50));
		
		this.getChildren().addAll(score, timer, buttonsBox);
		this.setAlignment(Pos.CENTER_LEFT);
		HBox.setMargin(score, new Insets(10, 20, 0, 50));
		HBox.setMargin(timer, new Insets(10, 0, 0, 50));
	}

}
