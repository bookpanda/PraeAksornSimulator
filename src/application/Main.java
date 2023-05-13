package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pane.RootPane;

public class Main extends Application {

	@Override
	public void start(Stage stage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("Scene1.fxml"));
			Scene scene = new Scene(root, 800, 640);
			stage.setScene(scene);
			stage.setResizable(false);
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}

//		RootPane rp = new RootPane();
//		Scene scene = new Scene(rp, 800, 640);
//		Stage stage1 = new Stage();
//		stage1.setTitle("PraeAksornSimulator");
//		stage1.setResizable(false);
//		stage1.setScene(scene);
//		stage1.show();
	}

	public static void main(String[] args) {
		launch();
	}
}