package application;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import pane.RootPane;

public class Main extends Application{
	@Override
	public void start(Stage stage) {
//		RootPane rp = new RootPane();
		
		//ส่วนที่เพิ่ม//////////////////////////////////////
		
		GridPane gp = new GridPane();
		for (int i = 0; i<4 ; i++) {
			RootPane rp = new RootPane();
			gp.add(rp, Math.round(i/2), i%2,1,1);
		}
		gp.setAlignment(Pos.CENTER);
		StackPane sp = new StackPane();
		sp.getChildren().add(gp);
		sp.resize(800, 640);
		
		StackPane.setAlignment(gp, Pos.CENTER);
		
		Scene scene = new Scene(sp, 800, 640);
		//////////////////////////////////////////////
		
		
//		Scene scene = new Scene(rp, 800, 640);
		
		Stage stage1 = new Stage();
		stage1.setTitle("PraeAksornSimulator");
		stage1.setResizable(false);
		stage1.setScene(scene);
		stage1.show();
	}

	public static void main(String[] args) {
		launch();
	}
}