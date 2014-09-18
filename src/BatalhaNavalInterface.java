import java.rmi.Remote;
import java.rmi.RemoteException;


public interface BatalhaNavalInterface extends Remote {
	public int registraUsuario(String nome) throws RemoteException;
    public String nomeOponente(int idUsuario) throws RemoteException;
    public int posicionaNavio(int idUsuario, String coord, int alin, int tipoNavio) throws RemoteException;
    public int posicionamentoPronto(int idUsuario) throws RemoteException;
    public int ehMinhaVez(int idUsuario) throws RemoteException;
    public String obtemTabuleiro(int idUsuario) throws RemoteException;
    public String obtemLancamentos(int idUsuario) throws RemoteException;
    public int executaTiro(int idUsuario, String coord) throws RemoteException;
}
