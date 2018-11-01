package main;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import main.view.JogoViewController;

public class MainApp extends Application {

	private Stage primaryStage;
	private AnchorPane rootLayout;

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("dos");
		this.primaryStage.setResizable(false);

		initRootLayout();

	}
	
	public MainApp() {
	}

	public void initRootLayout() {
		try {

			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/jogoView.fxml"));
			rootLayout = (AnchorPane) loader.load();

			JogoViewController controller = loader.getController();
			controller.setMainApp(this);

			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

//	public void showClientOverview() {
//		try {
//			FXMLLoader loader = new FXMLLoader();
//			loader.setLocation(MainApp.class.getResource("view/MainView.fxml"));
//			AnchorPane cartaOverview = (AnchorPane) loader.load();
//
//			rootLayout.setCenter(cartaOverview);
//
//			mainViewController = loader.getController();
//			mainViewController.setMainApp(this);
//
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}

	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public static void main(String[] args) {
		launch(args);
	}

}
