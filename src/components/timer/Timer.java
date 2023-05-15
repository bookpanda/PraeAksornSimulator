package components.timer;

import components.code.CodeWrapper;
import components.stats.HungerRunnable;
import components.stats.ThirstRunnable;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class Timer extends VBox {
	private static Timer timer = null;
	private CodeWrapper codeWrapper = CodeWrapper.getInstance();
	private int seconds;
	private boolean active;
	Text timeText;
	private Thread timeThread;
	private Thread thirstThread;
	private Thread hungerThread;

	private Timer() {
		setSeconds(60);
		timeText = new Text(String.valueOf(seconds));
		Text text = new Text("Time left");
		this.getChildren().addAll(text, timeText);
	}

	public static synchronized Timer getInstance() {
		if (timer == null)
			timer = new Timer();
		return timer;
	}

	public void start() {
		setSeconds(60);
		codeWrapper.getNewIndex();
		CodeRunnable cr = new CodeRunnable();
		ThirstRunnable tr = new ThirstRunnable();
		HungerRunnable hr = new HungerRunnable();
		if (timeThread != null)
			timeThread.interrupt();
		timeThread = new Thread(cr);
		timeThread.start();
		thirstThread = new Thread(tr);
		thirstThread.start();
		hungerThread = new Thread(hr);
		hungerThread.start();
	}

	public Text getTimeText() {
		return timeText;
	}

	public int getSeconds() {
		return seconds;
	}

	public void setSeconds(int seconds) {
		this.seconds = seconds;
	}

}
