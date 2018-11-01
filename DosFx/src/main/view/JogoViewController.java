package main.view;

import java.util.Collections;

import javax.swing.JOptionPane;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import main.MainApp;
import main.baralho.AcabouBaralhoException;
import main.baralho.Baralho;
import main.baralho.Carta;
import main.baralho.Cor;
import main.baralho.Pilha;

public class JogoViewController {

	@FXML
	private ImageView topo;

	@FXML
	private ImageView pilhaImg;

	@FXML
	private ListView<Carta> listView;
	
	@FXML
	private Label cor;

	private MainApp mainApp;

	private Pilha pilha;

	private ObservableList<Carta> cartaData = FXCollections.observableArrayList();

	private Baralho b;

	@FXML
	private void initialize() {
		b = new Baralho();
		pilha = new Pilha();
		try {
			cartaData.addAll(b.get(20));
			pilha.adicionar(b.get(1).get(0));
			Collections.sort(cartaData);
		} catch (AcabouBaralhoException e) {
			e.printStackTrace();
		}
		atualizar();
	}

	public void atualizar() {
		topo.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent click) {
				try {
					cartaData.add(b.get(1).get(0));
					Collections.sort(cartaData);
				} catch (AcabouBaralhoException e) {
					b.reembaralhar(pilha.reembaralhar());
					try {
						cartaData.add(b.get(1).get(0));
						Collections.sort(cartaData);
					} catch (AcabouBaralhoException e1) {
						System.exit(0);
					}
				}
				
			}
		});
		topo.setImage(new Image("file:resources/images/fundo.png"));
		pilhaImg.setImage(new Image(
				"file:resources/images/" + pilha.topo().getCor().ordem + "/" + pilha.topo().getValor().ordem + ".png"));
		listView.setItems(cartaData);
		listView.setCellFactory(param -> new ListCell<Carta>() {
			private ImageView imageView = new ImageView();

			@Override
			public void updateItem(Carta carta, boolean empty) {
				super.updateItem(carta, empty);
				if (empty) {
					setText(null);
					setGraphic(null);
				} else {
					Image img = new Image(
							"file:resources/images/" + carta.getCor().ordem + "/" + carta.getValor().ordem + ".png");

					imageView.setImage(img);
					imageView.fitWidthProperty().set(124);

					imageView.fitHeightProperty().set(190);
					setGraphic(imageView);
				}
			}
		});
		listView.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent click) {

				if (click.getClickCount() == 2) {
					MultipleSelectionModel<Carta> currentItemSelected = listView.getSelectionModel();
					Carta carta = currentItemSelected.getSelectedItem();
					if (pilha.topo().getCor() == carta.getCor() || pilha.topo().getValor() == carta.getValor() || carta.getCor() == Cor.preto) {
						cor.setText("");
						cartaData.remove(carta);
						pilhaImg.setImage(new Image(
								"file:resources/images/" + carta.getCor().ordem + "/" + carta.getValor().ordem + ".png"));
						if (carta.getCor() == Cor.preto) {
							int op = JOptionPane.showOptionDialog(null, "Escolha a cor", "Cor da carta preta", 0, 0, null, new String[]{"azul", "verde", "vermelho", "amarelo"}, null);
							switch (op) {
							case 0:
								cor.setText("Azul");
								cor.setTextFill(Color.BLUE);
								carta.setCor(Cor.azul);
								break;
							case 1:
								cor.setText("Verde");
								cor.setTextFill(Color.GREEN);
								carta.setCor(Cor.verde);
								break;
							case 2:
								cor.setText("Vermelho");
								cor.setTextFill(Color.RED);
								carta.setCor(Cor.vermelho);
								break;
							case 3:
								cor.setText("Amarelo");
								cor.setTextFill(Color.YELLOW);
								carta.setCor(Cor.amarelo);
								break;
							}
						}
						pilha.adicionar(carta);
					}

				}
			}
		});

	}

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}

}
