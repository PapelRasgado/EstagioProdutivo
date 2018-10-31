package main.baralho;

import java.util.ArrayList;

public class Pilha {
	
	class Elemento{
		
		Carta valor;
		Elemento anterior;
		
	}
	
	private Elemento topo;
	
	public void adicionar(Carta carta) {
		Elemento novo = new Elemento();
		novo.valor = carta;
		novo.anterior = topo;
		topo = novo;
	}
	
	public ArrayList<Carta> reembaralhar(){
		ArrayList<Carta> retorno = new ArrayList<>();
		Elemento elemento = topo.anterior;
		while(elemento != null) {
			retorno.add(elemento.valor);
			elemento = elemento.anterior;
		}
		topo.anterior = null;
		return retorno;
	}
	
	public Carta topo() {
		return topo.valor;
	}

}
