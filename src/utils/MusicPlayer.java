/**
 * Plays music of current code
 */
package utils;

import java.io.File;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class MusicPlayer {
	private static Media media;
	private static MediaPlayer mediaPlayer;

	public static boolean loadMusic(String musicName) {
		if (mediaPlayer != null) {
			mediaPlayer.stop();
		}
		String musicPath = "src/music/codes/" + musicName + ".mp3";

		media = new Media(new File(musicPath).toURI().toString());
		if (media.getError() != null) {
			return false;
		}
		mediaPlayer = new MediaPlayer(media);
		return true;
	}

	public static void playMusic() {
		if (mediaPlayer != null) {
			mediaPlayer.play();
		}
	}

	public static void pauseMusic() {
		if (mediaPlayer != null) {
			mediaPlayer.pause();
		}
	}
}
