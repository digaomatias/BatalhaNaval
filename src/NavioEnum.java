
public enum NavioEnum {
	Submarino(1),
	Cruzador(2),
	Encouracado(3),
	PortaAvioes(4);
	
	
	private int value;
	
	NavioEnum(int value) {
		this.value = value;
	}
	
	public int getVal() {
		return value;
	}				
}
