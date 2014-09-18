
public enum PosicionamentoProntoResult {
	Pronto (0),
	UsuarioNaoEncontrado(-1);
	
	
	private int value;
	
	PosicionamentoProntoResult(int value) {
		this.value = value;
	}
	
	public int getVal() {
		return value;
	}				
}
