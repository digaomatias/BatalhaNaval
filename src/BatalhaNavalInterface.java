import java.rmi.Remote;
import java.rmi.RemoteException;


public interface BatalhaNavalInterface extends Remote {
	public double calcula(int n) throws RemoteException;
    public int registraUsuario(String nome) throws RemoteException;
    public int temAdversario(int idUsuario) throws RemoteException;
    public int posicionaBarco(int idUsuario, int px, int py, int alin, int tipoBarco) throws RemoteException;
    public int jogoPronto(int idUsuario) throws RemoteException;
    //public int ehMinhaVez(int idUsuario) throws RemoteException;
    //public int darTiro(int idUsuario, int posX, int posY) throws RemoteException;
    //public Estado obtemEstado(int idUsuario) throws RemoteException;
}
