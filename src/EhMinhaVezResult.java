
public enum EhMinhaVezResult {
	Erro(-1),
	Nao(0),
	Sim (1),
	Vencedor (2),
	Perdedor (3);
	
	
	private int value;
	
	EhMinhaVezResult(int value) {
		this.value = value;
	}
	
	public int getVal() {
		return value;
	}				
}
