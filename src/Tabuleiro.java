
public class Tabuleiro {
	
	public int x;
	public int y;
	public int[][] disposicao;
		
	public Tabuleiro(int x, int y)
	{
		this.x = x;
		this.y = y;
		this.disposicao = new int[x][y];		
		initialize();
	}
	
	private void initialize()
	{
		for(int i=0; i < x; i++)
			for(int h=0; h < y; h++)
				disposicao[i][h] = 0;
	}
	
	private boolean temNavioProximo(int x, int y, int offset, OrientacaoEnum orientacao)
	{
		if(orientacao == OrientacaoEnum.Horizontal)
		{
			//Agora vamos ver se respeita a distancia de 1 quadro dos outros navios
			int startX = x == 0 ? 0 : x-1;
			int endX = x == this.x-1 ? x : x + 2;
			int startY = y == 0 ? 0 : y-1;
			int endY = y+offset == this.y ? y+offset : y+offset+1 ;
					
					
			for(int i = startX; i < endX ; i++)
				for(int h = startY; h < endY; h++)
				{
					if(i == x-1 || i == x+1)
						if(h == y-1 || h == y+offset)
							continue;
								
					if(disposicao[i][h] > 0)
						return true;
				}
		}
		else {
			//Agora vamos ver se respeita a distancia de 1 quadro dos outros navios
			int startY = y == 0 ? 0 : y-1;
			int endY = y == this.y-1 ? y : y + 2;
			int startX = x == 0 ? 0 : x-1;
			int endX = x+offset == this.x ? x+offset : x+offset+1 ;
					
				
			for(int h = startY; h < endY; h++)
				for(int i = startX; i < endX ; i++)				
				{
					if(i == x-1 || i == x+offset)
						if(h == y-1 || h == y+1)
							continue;
								
					if(disposicao[i][h] > 0)
						return true;
				}
		}
		
		return false;
	}
	
	private boolean isPosicaoValida(TabuleiroCoord posicaoInicial, int offset, OrientacaoEnum orientacao)
	{
		int x = posicaoInicial.getX();
		int y = posicaoInicial.getY();
		
		//Verifica se as posições iniciais já estão fora do tabuleiro.
		if(x < 0 || y < 0 || x >= this.x || y >= this.y)
			return false;
		
		//Se a possição final da alocação do navio estará fora dos limites do tabuleiro ou se tem navio proximo
		int endY = y+offset;
		int endX = x+offset;
		
		if(orientacao == OrientacaoEnum.Horizontal)
			return !(endY > this.y || temNavioProximo(x, y, offset, orientacao));
		else
			return !(endX > this.x || temNavioProximo(x, y, offset, orientacao));
	}
	
	
	public boolean posicionaNavio(String posicao, NavioEnum navioTipo, OrientacaoEnum orientacao)
	{
		TabuleiroCoord posicaoInicial = TabuleiroCoord.fromString(posicao);
		int navioSize = navioTipo.getSize();
		if(!isPosicaoValida(posicaoInicial, navioSize, orientacao))
			return false;
		
		int x = posicaoInicial.getX();
		int y = posicaoInicial.getY();
					
		if(orientacao != OrientacaoEnum.Horizontal)
		{
			int aux = x;
			x = y;
			y = aux;
		} 
				
		for(int i = y; i < y+navioSize; i++)			
			disposicao[orientacao != OrientacaoEnum.Horizontal ? i : x][orientacao != OrientacaoEnum.Horizontal ? x : i] = navioTipo.getVal();
		
		return true;
	}
	
	public int getPosicao(TabuleiroCoord coord)
	{
		//-1 Fora dos limites do tabuleiro
		if(coord.getX() >= x || coord.getX() < 0 || coord.getY() >= y || coord.getY() < 0)
			return -1;
		
		return disposicao[coord.getX()][coord.getY()];
	}
	
	public String toOpponentString()	
	{
		StringBuilder builder = new StringBuilder();
		
		for(int i=0; i < x; i++) {
			for(int h=0; h < y; h++)
				builder.append(disposicao[i][h] == 0 ? "." : disposicao[i][h]);
			builder.append('\n');
		}
		
		return builder.toString();
	}
	
	@Override
	public String toString()	
	{
		StringBuilder builder = new StringBuilder();
		
		for(int i=0; i < x; i++) {
			for(int h=0; h < y; h++)
				builder.append(disposicao[i][h] == 0 ? "." : disposicao[i][h]);
			builder.append('\n');
		}
		
		return builder.toString();
	}	
}
