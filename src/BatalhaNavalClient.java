import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.Naming;


public class BatalhaNavalClient {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int idUsuario;
	static boolean pronto = false;
	public static void main(String[] args) {
		if	(args.length != 2)  {
			System.out.println("Uso: java BatalhaNavalClient <maquina> <nome>");
			System.exit(1);
		}
		try {
			
			
			BatalhaNavalInterface batalhaNaval = (BatalhaNavalInterface) Naming.lookup ("//"+args[0]+"/BatalhaNaval");
			idUsuario = batalhaNaval.registraUsuario(args[1]);
			if(idUsuario == -1) {
				System.out.println("Usu�rio j� cadastrado.");
				System.exit(0);
			}
			if(idUsuario == -2) {
				System.out.println("N�o eh possivel registrar novos usuarios (jogo cheio).");
				System.exit(0);
			}
			
			System.out.println("Ol� "+args[1] + ". Selecione uma das op��es do menu.");
			System.out.println(getMenu());
			
			boolean jogando= true;
			int result;
			String coord;
			while(jogando)
			{
				try{
		            int option = Integer.parseInt(br.readLine());
		            
		            switch(option)
		            {
		            	case 1: 
		            		System.out.println(batalhaNaval.nomeOponente(idUsuario));
		            		break;
		            	case 2:	            		
		            		if(pronto)
		            		{
		            			System.out.println("Navios ja posicionados.");
		            		}
		            		
		            		coord = entrarCoordenada();
		            		int orientacao = entrarOrientacao();            				            		
		            		int tipoNavio = entrarTipoNavio();
		            			
		            		result = batalhaNaval.posicionaNavio(idUsuario, coord, orientacao, tipoNavio);
		            		System.out.println(PosicionaNavioResult.fromInt(result).toString());
		            		break;
		            	case 3:
		            		result = batalhaNaval.posicionamentoPronto(idUsuario);
		            		if(result == 0)
		            		{
		            			System.out.println("Pronto!");
		            			pronto = true;
		            		}
		            		else if(result == -1)
		            			System.out.println("Usu�rio n�o encontrado!");
		            		else System.out.println("Pr�ximo a posicionar: " + NavioEnum.getNome(result));		            			
		            		
		            		break;
		            	case 4: 
		            		result = batalhaNaval.ehMinhaVez(idUsuario);
		            		System.out.println(EhMinhaVezResult.getString(result));
		            		break;
		            	case 5: 
		            		System.out.println(batalhaNaval.obtemTabuleiro(idUsuario));
		            		break;
		            	case 6: 
		            		System.out.println(batalhaNaval.obtemLancamentos(idUsuario));
		            		break;	
		            	case 7: 
		            		do 
		            		{
			            		coord = entrarCoordenada();
			            		result = batalhaNaval.executaTiro(idUsuario, coord);
		            		} while(ExecutaTiroResult.fromInt(result) == ExecutaTiroResult.TiroJahDisparado);
		            		
		            		break;	
		            	case 9: 
		            		System.out.println(getMenu());
		            		break;
		            	case 0: 
		            		System.out.println("Volte sempre!");
		            		System.exit(0);
		            		break;
		            	default:
		            		System.err.println("Op��o inv�lida!");
				            System.out.println(getMenu());
				            break;
		            }
		            
		        }catch(NumberFormatException nfe){
		            System.err.println("Op��o inv�lida!");
		            System.out.println(getMenu());		            
		        }
			}
		} catch (Exception e) {
			System.out.println ("BatalhaNavalClient failed.");
			e.printStackTrace();
		}
	}
	
	private static String entrarCoordenada() throws IOException 
	{
		String coord = null;
		do {
			System.out.println("Digite a coordenada, no Formato <Letra><Numero>. Ex: A3, B2");
			coord = br.readLine();
			if(coord.length() != 2)
				System.out.println("Coordenada inv�lida.");
		} while(coord.length() != 2);
		
		return coord;
	}
	
	private static int entrarOrientacao() throws IOException{
		int orientacao = 2;		            		
		while(orientacao > 1) {
			try
			{		
				System.out.println("Selecione a orienta��o: \r\n0: Horizontal\r\n1: Vertical");				
				orientacao = Integer.parseInt(br.readLine());
    			
    			if(orientacao > 1)
    			{
    				System.out.println("Orienta��o inv�lida!");
    				continue;
    			}
			}
			catch(NumberFormatException nfe)
			{
				System.out.println("Orienta��o inv�lida!");
				continue;
			}
		} 
		
		return orientacao;
	}
	
	private static int entrarTipoNavio() throws IOException{
		NavioEnum navio = null;		            		
		while(navio == null) {
			try
			{	
				System.out.println("Selecione o navio: \r\n" + NavioEnum.getOpcoes());
    			int navioTipo = Integer.parseInt(br.readLine());
    			navio = NavioEnum.fromInt(navioTipo);
    			if(navio == null)
    			{
    				System.out.println("Tipo de navio inv�lido!");
    				continue;
    			}
			}
			catch(NumberFormatException nfe)
			{
				System.out.println("Orienta��o inv�lida!");
				continue;
			}
		} 
		
		return navio.getVal();
	}
	
	private static String getMenu()
	{
		return "MENU: \r\n"+
				"1: Nome do oponente\r\n"+
				"2: Posiciona navio\r\n"+
				"3: Posicionamento pronto?\r\n"+
				"4: Eh minha vez?\r\n"+
				"5: Obtem tabuleiro\r\n"+
				"6: Obtem lan�amentos\r\n"+
				"7: Executa tiro\r\n"+
				"9: Ver menu\r\n"+
				"0: Sair\r\n";				
	}
}
