
public enum PosicionaNavioResult {
	Sucesso(0),
	UsuarioNaoEncontrado(-1),
	PosicionamentoInvalido (-2),
	TipoNavioJahPosicionado (-3),
	PosicionamentoConcluido (-4);
	
	
	private int value;
	
	PosicionaNavioResult(int value) {
		this.value = value;
	}
	
	public int getVal() {
		return value;
	}				
}
