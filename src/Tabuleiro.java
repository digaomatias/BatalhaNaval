
public class Tabuleiro {
	
	public int x;
	public int y;
	public int[][] disposicao;
		
	public Tabuleiro(int x, int y)
	{
		this.disposicao = new int[x][y];		
		initialize();
	}
	
	private void initialize()
	{
		for(int i=0; i < x; i++)
			for(int h=0; h < y; h++)
				disposicao[i][h] = 0;
	}
	
	public int getCoord(String posicao) {
		if(posicao.length() != 2)
			throw new IllegalArgumentException("posicao deve ser no formato:B1, C4, A3");
		
		//colocando em lowerCase pra pegar o ascii number correto.
		posicao = posicao.toLowerCase();

		//TODO verificar se realmente é uma letra seguida de um número
		char letter = posicao.charAt(0);
		char number = posicao.charAt(1);
		
		// Aqui eu subtraio 97. Por exemplo a equivale a 97 em ascii
		return disposicao[((int)letter)-97][(int)number];
	}
	
	@Override
	public String toString()	
	{
		StringBuilder builder = new StringBuilder();
		
		for(int i=0; i < x; i++) {
			for(int h=0; h < y; h++)
				builder.append(disposicao[i][h] == 0 ? '.' : 'X');
			builder.append('\n');
		}
		
		return builder.toString();
	}
}
