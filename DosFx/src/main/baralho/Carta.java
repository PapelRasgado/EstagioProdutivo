package main.baralho;

public class Carta {

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

}
