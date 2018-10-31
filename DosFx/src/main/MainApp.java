package main;

import java.io.IOException;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import main.baralho.Carta;
import main.view.jogoViewController;

public class MainApp extends Application {

	private Stage primaryStage;
	private AnchorPane rootLayout;

	private ObservableList<Carta> cartaData = FXCollections.observableArrayList();

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("WebZapZap");
		this.primaryStage.setResizable(false);

		initRootLayout();

	}

	public ObservableList<Carta> getCartaData() {
		return cartaData;
	}
	

	public MainApp() {

	}

	public void initRootLayout() {
		try {

			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/jogoView.fxml"));
			rootLayout = (AnchorPane) loader.load();

			jogoViewController controller = loader.getController();
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
