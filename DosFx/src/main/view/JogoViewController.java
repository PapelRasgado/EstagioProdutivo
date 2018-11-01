package main.view;

import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import main.MainApp;
import main.baralho.Carta;

public class JogoViewController {

	@FXML
	private ImageView topo;
	
	@FXML
	private ListView<Carta> listView;
	
	private MainApp mainApp;

	@FXML
	private void initialize() {
		
	}
	
	public void atualizar() {
		topo.setImage(new Image("file:resources/images/fundo.png"));
		listView.setItems(mainApp.getCartaData());
		listView.setCellFactory(param -> new ListCell<Carta>() {
			private ImageView imageView = new ImageView();

			@Override
			public void updateItem(Carta carta, boolean empty) {
				super.updateItem(carta, empty);
				if (empty) {
					setText(null);
					setGraphic(null);
				} else {
					Image img = new Image("file:resources/images/"+ carta.getCor().ordem + "/"+ carta.getValor().ordem + ".png");
					
					imageView.setImage(img);
					imageView.fitWidthProperty().set(124);

					imageView.fitHeightProperty().set(190);
					setGraphic(imageView);
				}
			}
		});

	}


	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}

}
