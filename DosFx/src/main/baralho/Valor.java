package main.baralho;

public enum Valor {
	C0("0"), C1("1"), C2("2"), C3("3"), C4("4"), C5("5"), C6("6"), C7("7"), C8("8"), C9("9"),
	C10("Inverter"), C11("Bloquear"), C12("+2"), C13("Coringa"), C14("Coringa +4");
	
	public String valor;
	
	private Valor(String valor) {
		this.valor = valor;
	}
}
