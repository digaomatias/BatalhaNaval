
public enum ExecutaTiroResult {
	JogadorInvalido(-1),
	JogadorSemCondicao(-2),
	TiroJahDisparado (-3),
	TiroNaAgua (0),
	TiroCerteiro (1);
	
	
	private int value;
	
	ExecutaTiroResult(int value) {
		this.value = value;
	}
	
	public int getVal() {
		return value;
	}				
}
