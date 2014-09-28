
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
	
	public static String getString(int num) {
		switch(num)
		{
			case -1:
				return "Jogo ainda não começou, ou houve outro erro.";
			case 0:
				return "Não é sua vez.";
			case 1:
				return "É sua vez!";
			case 2:
				return "Você é o vencedor!";				
			case 3:
				return "Você foi derrotado!";
		}	
		
		return "";
	}
}
