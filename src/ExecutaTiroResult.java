
public enum ExecutaTiroResult {
	JogadorInvalido(-1),
	CoordenadaInvalida (-2),
	JogadorSemCondicao(-3),
	TiroJahDisparado (-4),	
	TiroNaAgua (0),
	TiroCerteiro (1);
	
	
	private int value;
	
	ExecutaTiroResult(int value) {
		this.value = value;
	}
	
	public int getVal() {
		return value;
	}
	
	public static ExecutaTiroResult fromInt(int num)
	{
		switch(num)
		{
			case -1:
				return JogadorInvalido;
			case -2:
				return CoordenadaInvalida;
			case -3:
				return JogadorSemCondicao;
			case -4:
				return TiroJahDisparado;				
			case 0:
				return TiroNaAgua;
			case 1:
				return TiroCerteiro;
		}	
		
		return null;
	}
	
	public static String getString(int num) {
		switch(num)
		{
			case -1:
				return "Jogador inválido.";
			case -2:
				return "Coordenada inválida.";
			case -3:
				return "Aguarde a sua vez ou entrar seu oponente.";
			case -4:
				return "Tiro já disparado.";				
			case 0:
				return "Tiro na água.";
			case 1:
				return "Tiro certeiro!!";
		}	
		
		return "";
	}
}
