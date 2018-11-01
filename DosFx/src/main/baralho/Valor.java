package main.baralho;

public enum Valor {
	C0("0", 0), C1("1", 1), C2("2", 2), C3("3", 3), C4("4", 4), C5("5", 5), C6("6", 6), C7("7", 7), C8("8", 8), C9("9", 9),
	C10("Inverter", 10), C11("Bloquear", 11), C12("+2", 12), C13("Coringa", 13), C14("Coringa +4", 14);
	
	public String valor;
	
	public int ordem;
	
	private Valor(String valor, int ordem) {
		this.valor = valor;
		this.ordem = ordem;
	}
}
