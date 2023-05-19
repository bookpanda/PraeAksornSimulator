/**
 * Timer is responsible for starting, pausing and exiting the game
 */
package components.timer;

import components.code.CodeWrapper;
import components.plate.Plate;
import components.stats.HungerBar;
import components.stats.StatsRunnable;
import components.stats.ThirstBar;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import score.Score;
import utils.MusicPlayer;

public class Timer extends VBox {
	private static Timer timer = null;
	private int seconds;
	private int round;
	private Text timeText;
	private boolean isActive;
	private Plate plate;
	private ThirstBar thirstBar;
	private HungerBar hungerBar;
	private Thread timeThread;
	private Thread thirstThread;
	private Thread hungerThread;
	private CodeWrapper codeWrapper;
	private Score score;

	private Timer() {
		thirstBar = ThirstBar.getInstance();
		hungerBar = HungerBar.getInstance();
		codeWrapper = CodeWrapper.getInstance();
		score = Score.getInstance();
		setIsActive(false);
		setSeconds(90);
		setRound(0);
		Text text = new Text("Time left");
		text.setFont(new Font(null, 20));
		timeText = new Text(String.valueOf(seconds));
		timeText.setFont(new Font(null, 20));
		this.getChildren().addAll(text, timeText);
	}

	public static synchronized Timer getInstance() {
		if (timer == null)
			timer = new Timer();
		return timer;
	}

	/**
	 * Starts/Restarts game with 90 seconds per round, thirst and hunger set to 200,
	 * score set to 0 and threads are initialized
	 */
	public void start() {
		setIsActive(true);
		plate = Plate.getInstance();
		plate.reset();
		PauseButton pauseButton = PauseButton.getInstance();
		pauseButton.setDisable(false);
		pauseButton.setText("Pause");
		StartButton startButton = StartButton.getInstance();
		startButton.setText("Restart");
		codeWrapper.reset();
		score.setPoints(0);
		setSeconds(90);
		setRound(0);
		thirstBar.setStats(200);
		hungerBar.setStats(200);
		killThreads();
		startThreads(false);
	}

	/**
	 * Pause and resume
	 */
	public void pause() {
		PauseButton pauseButton = PauseButton.getInstance();
		if (isActive()) {
			pauseButton.setText("Resume");
			MusicPlayer.pauseMusic();
			killThreads();
		} else {
			pauseButton.setText("Pause");
			startThreads(true);
		}
		setIsActive(!this.isActive);
	}

	/**
	 * Starts threads for timer, hunger and thirst
	 */
	private void startThreads(boolean isPause) {
		TimeRunnable timeRunnable = new TimeRunnable(this.getSeconds(), 5 - this.getRound(), isPause);
		timeThread = new Thread(timeRunnable);
		timeThread.start();
		StatsRunnable thirstRunnable = new StatsRunnable(thirstBar, thirstBar.getStats(), 300);
		thirstThread = new Thread(thirstRunnable);
		thirstThread.start();
		StatsRunnable hungerRunnable = new StatsRunnable(hungerBar, hungerBar.getStats(), 500);
		hungerThread = new Thread(hungerRunnable);
		hungerThread.start();
	}

	/**
	 * Kills threads for timer, hunger and thirst
	 */
	private void killThreads() {
		if (timeThread != null)
			timeThread.interrupt();
		if (thirstThread != null)
			thirstThread.interrupt();
		if (hungerThread != null)
			hungerThread.interrupt();
	}

	public void exit() {
		killThreads();
		System.exit(1);
	}

	public Text getTimeText() {
		return timeText;
	}

	public int getSeconds() {
		return seconds;
	}

	public void setSeconds(int seconds) {
		this.seconds = seconds;
		if (timeText != null)
			timeText.setText(String.valueOf(seconds));
	}

	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}

	public boolean isActive() {
		return this.isActive;
	}

	public int getRound() {
		return round;
	}

	public void setRound(int round) {
		this.round = round;
	}

}
