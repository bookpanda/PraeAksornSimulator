package utils;

import java.io.File;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class AmbiencePlayer {
	private static Media media;
	private static MediaPlayer mediaPlayer;

	public static boolean loadSound(String ambienceName) {
		if (mediaPlayer != null) {
			mediaPlayer.stop();
		}
		String soundPath = "src/music/ambience/" + ambienceName + ".mp3";

		media = new Media(new File(soundPath).toURI().toString());
		if (media.getError() != null) {
			return false;
		}
		mediaPlayer = new MediaPlayer(media);
		return true;
	}

	public static void playSound() {
		if (mediaPlayer != null) {
			mediaPlayer.play();
		}
	}

	public static void stopSound() {
		if (mediaPlayer != null) {
			mediaPlayer.stop();
		}
	}
}
