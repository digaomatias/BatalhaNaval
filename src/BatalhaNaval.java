import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class BatalhaNaval extends UnicastRemoteObject implements BatalhaNavalInterface {
	
	private Jogador[] jogadores;
		
	/**
	 * 
	 */
	private static final long serialVersionUID = -488221494018748658L;

	protected BatalhaNaval() throws RemoteException {
		super();
		
		this.jogadores = new Jogador[2];
	}

	@Override
	public int registraUsuario(String nome) throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String nomeOponente(int idUsuario) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int posicionaNavio(int idUsuario, String coord, int alin,
			int tipoNavio) throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int posicionamentoPronto(int idUsuario) throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int ehMinhaVez(int idUsuario) throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String obtemTabuleiro(int idUsuario) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String obtemLancamentos(int idUsuario) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int executaTiro(int idUsuario, String coord) throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

}
