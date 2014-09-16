import java.rmi.Naming;


public class BatalhaNavalClient {

	public static void main(String[] args) {
		double n;

		if	(args.length != 2)  {
			System.out.println("Uso: java FatorialClient <maquina> <int>");
			System.exit(1);
		}
		try {
			BatalhaNavalInterface nota = (BatalhaNavalInterface) Naming.lookup ("//"+args[0]+"/Fatorial");
			n = nota.calcula(Integer.parseInt(args[1]));
			System.out.println ("Num: "+args[1]);
			System.out.println ("Fatorial: "+n);
		} catch (Exception e) {
			System.out.println ("FatorialClient failed.");
			e.printStackTrace();
		}

	}

}
