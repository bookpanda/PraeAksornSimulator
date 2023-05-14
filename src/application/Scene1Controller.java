package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import pane.RootPane;

public class Scene1Controller {
	private Stage stage;
	private Scene scene;

	public void switchToScene2(ActionEvent event) throws IOException {
		RootPane rp = RootPane.getInstance();
		scene = new Scene(rp, 1000, 700);
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setTitle("PraeAksornSimulator");
		stage.setResizable(false);
		stage.setScene(scene);
		stage.show();
	}
}
