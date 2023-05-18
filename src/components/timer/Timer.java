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
	private boolean active;
	private Plate plate;
	private ThirstBar tb;
	private HungerBar hb;
	private Thread timeThread;
	private Thread thirstThread;
	private Thread hungerThread;
	private CodeWrapper codeWrapper;
	private Score score;

	private Timer() {
		this.active = false;
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

	public void start() {
		this.active = true;
		plate = Plate.getInstance();
		plate.reset();
		PauseButton pauseButton = PauseButton.getInstance();
		pauseButton.setDisable(false);
		pauseButton.setText("Pause");
		StartButton startButton = StartButton.getInstance();
		startButton.setText("Restart");
		codeWrapper = CodeWrapper.getInstance();
		codeWrapper.reset();
		score = Score.getInstance();
		score.setPoints(0);
		setSeconds(90);
		setRound(0);
		TimeRunnable timer = new TimeRunnable(this.getSeconds(), 5 - this.getRound(), false);
		tb = ThirstBar.getInstance();
		tb.setStats(200);
		StatsRunnable tr = new StatsRunnable(tb, tb.getStats(), 300);
		hb = HungerBar.getInstance();
		hb.setStats(200);
		StatsRunnable hr = new StatsRunnable(hb, hb.getStats(), 400);
		if (timeThread != null)
			timeThread.interrupt();
		timeThread = new Thread(timer);
		timeThread.start();
		if (thirstThread != null)
			thirstThread.interrupt();
		thirstThread = new Thread(tr);
		thirstThread.start();
		if (hungerThread != null)
			hungerThread.interrupt();
		hungerThread = new Thread(hr);
		hungerThread.start();
	}

	public void pause() {
		PauseButton pauseButton = PauseButton.getInstance();
		if (this.active) {
			pauseButton.setText("Resume");
			MusicPlayer.pauseMusic();
			if (timeThread != null)
				timeThread.interrupt();
			if (thirstThread != null)
				thirstThread.interrupt();
			if (hungerThread != null)
				hungerThread.interrupt();

		} else {
			pauseButton.setText("Pause");
			TimeRunnable timer = new TimeRunnable(this.getSeconds(), 5 - this.getRound(), true);
			tb = ThirstBar.getInstance();
			StatsRunnable tr = new StatsRunnable(tb, tb.getStats(), 300);
			hb = HungerBar.getInstance();
			StatsRunnable hr = new StatsRunnable(hb, hb.getStats(), 500);
			timeThread = new Thread(timer);
			timeThread.start();
			thirstThread = new Thread(tr);
			thirstThread.start();
			hungerThread = new Thread(hr);
			hungerThread.start();
		}
		this.active = !this.active;
	}

	public void exit() {
		if (timeThread != null)
			timeThread.interrupt();
		if (thirstThread != null)
			thirstThread.interrupt();
		if (hungerThread != null)
			hungerThread.interrupt();
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

	public boolean isActive() {
		return this.active;
	}

	public int getRound() {
		return round;
	}

	public void setRound(int round) {
		this.round = round;
	}

}
