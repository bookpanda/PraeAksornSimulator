/**
 * Controls the routing of pages in the program
 */
package application;

import java.io.IOException;

import components.timer.Timer;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pane.RootPane;

public class SceneController {
	private Stage stage;
	private Scene scene;
	private Parent root;

	/**
	 * Main game play is built without SceneBuilder
	 */
	public void switchToGameplay(ActionEvent event) throws IOException {
		RootPane rootPane = RootPane.getInstance();
		scene = new Scene(rootPane, 1000, 750);
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setTitle("PraeAksornSimulator");
		stage.setResizable(false);
		stage.setScene(scene);
		stage.show();
	}

	public void switchToHome(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("Home.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	public void switchToRules(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("Rules.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	public void exitProgram() {
		Timer timer = Timer.getInstance();
		timer.exit();
	}

}
