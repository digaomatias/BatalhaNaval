import java.rmi.RemoteException;


public class Partidas {
	private BatalhaNaval [] partidas;
	
	public Partidas(int numPartidas) throws RemoteException {
		this.partidas = new BatalhaNaval[numPartidas];
		
		for (int i=0; i < partidas.length; ++i)
			this.partidas[i] = new BatalhaNaval();
	}
}
