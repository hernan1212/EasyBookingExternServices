package gateway;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IPayment extends Remote
{
	public String PagoReserva(String user, int Precio) throws RemoteException;;
}