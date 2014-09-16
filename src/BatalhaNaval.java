import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class BatalhaNaval extends UnicastRemoteObject implements BatalhaNavalInterface {

	/**
	 * 
	 */
	private static final long serialVersionUID = -488221494018748658L;

	protected BatalhaNaval() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public double calcula(int n) throws RemoteException {
		double res = 1.0;
		
		while(n >= 1)
			res *= n-1;

		return res;
	}

	@Override
	public int registraUsuario(String nome) throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int temAdversario(int idUsuario) throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int posicionaBarco(int idUsuario, int px, int py, int alin,
			int tipoBarco) throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int jogoPronto(int idUsuario) throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

}
