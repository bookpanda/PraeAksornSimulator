package application;

import components.CodePaper;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pane.RootPane;

public class Main extends Application{
	@Override
	public void start(Stage stage) {
		RootPane rp = new RootPane();
		
//		StackPane sp = new StackPane();
//		sp.getChildren().add(gp);
//		sp.resize(800, 640);
//		
//		StackPane.setAlignment(gp, Pos.CENTER);
//		Scene scene = new Scene(sp, 800, 640);
		
		Scene scene = new Scene(rp, 800, 640);
		Stage stage1 = new Stage();
		stage1.setTitle("PraeAksornSimulator");
		stage1.setResizable(false);
		stage1.setScene(scene);
		stage1.show();
	}

	public static void main(String[] args) {
		CodePaper codePaper = new CodePaper();
		launch();
	}
//	public CodePaper getCodePaper() {
//		return codePaper;
//	}
}