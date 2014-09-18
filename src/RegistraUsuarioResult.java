
public enum RegistraUsuarioResult {
	JahCadastrado(-1),
	MaxAtingido(-2);
	
	
	private int value;
	
	RegistraUsuarioResult(int value) {
		this.value = value;
	}
	
	public int getVal() {
		return value;
	}				
}
