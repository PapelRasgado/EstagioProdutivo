package main.baralho;

public enum Cor {
	azul("Azul", 1), vermelho("Vermelho", 2), verde("Verde", 3), amarelo("Amarelo", 4), preto("Preto", 5);
	
	public String cor;
	
	public int ordem;
	
	private Cor(String cor, int ordem) {
		this.cor = cor;
		this.ordem  = ordem;
	}
}
