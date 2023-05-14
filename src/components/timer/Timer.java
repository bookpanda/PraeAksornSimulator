package components.timer;

import components.code.CodeWrapper;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class Timer extends VBox {
	private static Timer timer = null;
	private CodeWrapper codeWrapper = CodeWrapper.getInstance();
	private int seconds;
	private boolean active;
	Text timeText;
	private Thread thread;

	private Timer() {
		setSeconds(60);
		timeText = new Text(String.valueOf(seconds));
		Text text = new Text("Time left");
		this.getChildren().addAll(text, timeText);

//		thread = new Thread(() -> {
//			try {
//				String codeName = codeWrapper.getCurrentCodeName();
//				MusicPlayer.loadMusic(codeName);
//				MusicPlayer.playMusic();
//				while (seconds > 0) {
//					Thread.sleep(1000);
//					Platform.runLater(new Runnable() {
//						@Override
//						public void run() {
//							timeText.setText(String.valueOf(seconds));
//						}
//					});
//					setSeconds(seconds - 1);
//				}
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		});
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
		if (thread != null)
			thread.interrupt();
		thread = new Thread(cr);
		thread.start();
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
