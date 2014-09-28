
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
				return "Jogo ainda n�o come�ou, ou houve outro erro.";
			case 0:
				return "N�o � sua vez.";
			case 1:
				return "� sua vez!";
			case 2:
				return "Voc� � o vencedor!";				
			case 3:
				return "Voc� foi derrotado!";
		}	
		
		return "";
	}
}
