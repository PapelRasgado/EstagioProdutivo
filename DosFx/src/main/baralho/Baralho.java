package main.baralho;

import java.util.ArrayList;
import java.util.Collections;

public class Baralho {

	ArrayList<Carta> cartas;

	public Baralho() {
		cartas = new ArrayList<>();

		gerarBaralho();
	}

	private void gerarBaralho() {
		for (int i = 0; i < 4; i++) {
			cartas.add(new Carta(Cor.values()[i], Valor.C0));
		}

		for (int i = 0; i < 4; i++) {
			for (int j = 1; j < 13; j++) {
				cartas.add(new Carta(Cor.values()[i], Valor.values()[j]));
				cartas.add(new Carta(Cor.values()[i], Valor.values()[j]));
			}
		}

		for (int i = 13; i < 15; i++) {
			for (int j = 0; j < 4; j++) {
				cartas.add(new Carta(Cor.preto, Valor.values()[i]));
			}
		}
		
		Collections.shuffle(cartas);
	}
	
	public void reembaralhar(ArrayList<Carta> cartas) {
		this.cartas.addAll(cartas);
		Collections.shuffle(this.cartas);

	}
	
	public ArrayList<Carta> get(Integer quant) throws AcabouBaralhoException{
		if(cartas.size() < quant) {
			throw new AcabouBaralhoException();
		} else {
			ArrayList<Carta> retorno = new ArrayList<>();
			for (int i = 0; i < quant; i++) {
				retorno.add(cartas.remove(cartas.size()-1));
			}
			return retorno;
		}
	}

}
