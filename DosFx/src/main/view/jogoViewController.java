package main.view;

import java.time.format.DateTimeFormatter;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import main.MainApp;

public class jogoViewController {

	@FXML
	private ImageView topo;
	
	@FXML
	private TableView<String> listView;
	
	private MainApp mainApp;

	@FXML
	private void initialize() {
		topo.setImage(new Image("file:resources/images/teste.jpg"));
		listView.set

		listView.setCellFactory(param -> new ListCell<String>() {
			private ImageView imageView = new ImageView();

			@Override
			public void updateItem(String name, boolean empty) {
				super.updateItem(name, empty);
				if (empty) {
					setText(null);
					setGraphic(null);
				} else {
					if (name.equals("RUBY"))
						imageView.setImage(new Image("file:resources/images/teste.jpg"));
					else if (name.equals("APPLE"))
						imageView.setImage(new Image("file:resources/images/teste.jpg"));
					else if (name.equals("VISTA"))
						imageView.setImage(new Image("file:resources/images/teste.jpg"));
					else if (name.equals("TWITTER"))
						imageView.setImage(new Image("file:resources/images/teste.jpg"));
					setText(name);
					setGraphic(imageView);
				}
			}
		});
	}


	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}

}
