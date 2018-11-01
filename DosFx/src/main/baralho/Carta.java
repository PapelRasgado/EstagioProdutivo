package main.baralho;

public class Carta implements Comparable<Carta> {

	private Cor cor;
	
	private Valor valor;
	
	public Carta(Cor cor, Valor valor) {
		this.cor = cor;
		this.valor = valor;
	}

	public Cor getCor() {
		return cor;
	}

	public void setCor(Cor cor) {
		this.cor = cor;
	}

	public Valor getValor() {
		return valor;
	}

	public void setValor(Valor valor) {
		this.valor = valor;
	}
	
	@Override
	public String toString() {
		return valor.valor + " " + cor.cor;
	}

	@Override
	public int compareTo(Carta carta) {
		if (this.cor == carta.cor) {
			return valor.ordem - carta.valor.ordem;
		} else {
			return cor.ordem - carta.cor.ordem;
		}
	}

}
