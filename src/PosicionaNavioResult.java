
public enum PosicionaNavioResult {
	Sucesso(0),
	UsuarioNaoEncontrado(-1),
	PosicionamentoInvalido (-2),
	TipoNavioJahPosicionado (-3),
	TipoNavioInvalido (-4), 
	OrientacaoInvalida (-5);
	
	
	private int value;
	
	PosicionaNavioResult(int value) {
		this.value = value;
	}
	
	public int getVal() {
		return value;
	}
	
	@Override
	public String toString()
	{
		switch(this)
		{
			case Sucesso:
				return "Sucesso";
			case UsuarioNaoEncontrado:
				return "Usuário não encontrado";
			case PosicionamentoInvalido:
				return "Posicionamento inválido";
			case TipoNavioJahPosicionado:
				return "Tipo de navio já foi posicionado";				
			case TipoNavioInvalido:
				return "Tipo de navio inválido";
			case OrientacaoInvalida:
				return "Orientação inválida";
		}
		
		return super.toString();
	}
	
	public static PosicionaNavioResult fromInt(int r)	
	{
		switch(r)
		{
			case 0:
				return PosicionaNavioResult.Sucesso;
			case -1:
				return PosicionaNavioResult.UsuarioNaoEncontrado;
			case -2:
				return PosicionaNavioResult.PosicionamentoInvalido;
			case -3:
				return PosicionaNavioResult.TipoNavioJahPosicionado;
			case -4:
				return PosicionaNavioResult.TipoNavioInvalido;
			case -5:
				return PosicionaNavioResult.OrientacaoInvalida;			
		}
		
		return null;
	}
}
