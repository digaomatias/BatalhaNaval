
public enum OrientacaoEnum {
	Horizontal(0),
	Vertical(1);
		
	private int value;
	
	OrientacaoEnum(int value) {
		this.value = value;
	}
	
	public int getVal() {
		return value;
	}

	public static OrientacaoEnum fromInt(int alin) {
		switch(alin) {
	        case 0:
	            return OrientacaoEnum.Horizontal;
	        case 1:
	            return OrientacaoEnum.Vertical;
	    }
	    
	    return null;	
	}				
}
