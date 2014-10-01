
public class TabuleiroCoord
	{
		private int x, y;
		
		public TabuleiroCoord(int x, int y)
		{
			this.x = x;
			this.y = y;
		}
		
		public int getX() 
		{
			return x;
		}
		
		public int getY() 
		{
			return y;
		}
		
		public static TabuleiroCoord fromString(String posicao)
		{
			if(posicao.length() != 2)
				throw new IllegalArgumentException("posicao deve ser no formato:B1, C4, A3");
			
			//colocando em lowerCase pra pegar o ascii number correto.
			posicao = posicao.toLowerCase();

			//TODO verificar se realmente é uma letra seguida de um número
			char letter = posicao.charAt(0);
			String number = posicao.substring(1);
			
			// Aqui eu subtraio 97. Por exemplo a equivale a 97 em ascii		
			return new TabuleiroCoord(((int)letter)-97, Integer.parseInt(number));
		}
	}