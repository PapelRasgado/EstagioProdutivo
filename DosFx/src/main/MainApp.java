package main;

import java.io.IOException;
import java.util.Collections;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import main.baralho.AcabouBaralhoException;
import main.baralho.Baralho;
import main.baralho.Carta;
import main.view.JogoViewController;

public class MainApp extends Application {

	private Stage primaryStage;
	private AnchorPane rootLayout;
	private Baralho b;

	private ObservableList<Carta> cartaData = FXCollections.observableArrayList();

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("dos");
		this.primaryStage.setResizable(false);

		initRootLayout();

	}

	public ObservableList<Carta> getCartaData() {
		return cartaData;
	}

	public MainApp() {
		b = new Baralho();
		try {
			cartaData.addAll(b.get(20));
			Collections.sort(cartaData);
			System.out.println(cartaData.toString());
		} catch (AcabouBaralhoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void initRootLayout() {
		try {

			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/jogoView.fxml"));
			rootLayout = (AnchorPane) loader.load();

			JogoViewController controller = loader.getController();
			controller.setMainApp(this);
			controller.atualizar();

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
