import java.rmi.Naming;
import java.rmi.RemoteException;


public class BatalhaNavalServer {

	public static void main(String[] args) {
		try {
			java.rmi.registry.LocateRegistry.createRegistry(1099);
			System.out.println("RMI registry ready.");			
		} catch (RemoteException e) {
			System.out.println("RMI registry already running.");			
		}
		try {
			Naming.rebind ("BatalhaNaval", new BatalhaNaval ());
			System.out.println ("BatalhaNavalServer is ready.");
		} catch (Exception e) {
			System.out.println ("BaralhaNavalServer failed:");
			e.printStackTrace();
		}

	}

}
