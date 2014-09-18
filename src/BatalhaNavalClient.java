import java.rmi.Naming;


public class BatalhaNavalClient {

	public static void main(String[] args) {
		if	(args.length != 2)  {
			System.out.println("Uso: java FatorialClient <maquina> <int>");
			System.exit(1);
		}
		try {
			BatalhaNavalInterface batalhaNaval = (BatalhaNavalInterface) Naming.lookup ("//"+args[0]+"/BatalhaNaval");
		
			System.out.println ("Num: "+args[1]);
		} catch (Exception e) {
			System.out.println ("FatorialClient failed.");
			e.printStackTrace();
		}

	}

}
