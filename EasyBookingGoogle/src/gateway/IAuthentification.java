package gateway;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IAuthentification extends Remote{
	public boolean ComprobarUsuario(String usuario, String contrasena) throws RemoteException;;
}
