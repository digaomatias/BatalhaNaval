
public enum NavioEnum {
	Submarino(1),
	Cruzador(2),
	Encouracado(3),
	PortaAvioes(4);
	
	
	private int value;
	
	NavioEnum(int value) 
	{
		this.value = value;
	}
	
	public int getVal() 
	{
		return value;
	}				
	
	public int getSize()
	{
		switch(this)
		{
			case Submarino:
				return 1;
			case Cruzador:
				return 2;
			case Encouracado:
				return 3;
			case PortaAvioes:
				return 4;
		}
		
		return 0;
	}
	
	 public static NavioEnum fromInt(int x) {
	        switch(x) {
		        case 1:
		            return NavioEnum.Submarino;
		        case 2:
		            return NavioEnum.Cruzador;
		        case 3:
		            return NavioEnum.Encouracado;
		        case 4:
		            return NavioEnum.PortaAvioes;
	        }
	        
	        return null;	  
	 }
	 
	 public static String getNome(int tipo) {
		 switch(tipo)
		 {
		 	case 1:
	            return "Submarino";
	        case 2:
	            return "Cruzador";
	        case 3:
	            return "Encouraçado";
	        case 4:
	            return "Porta-Aviões";	           
		 }
		 
		 return "";
	 }
	 
	 public static String getOpcoes() {
		 return     "1: Submarino\r\n"+
					"2: Cruzador\r\n"+
					"3: Encouraçado\r\n"+
					"4: Porta Aviões\r\n";
	 }
}
