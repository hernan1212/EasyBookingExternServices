package gateway;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import airline.Flight;


public interface IAirline extends Remote{
	public List<Flight> BuscarVuelos(String origen, String destination, String fecha, int passenger) throws RemoteException;
	public List<Flight> BuscarTodoVuelos() throws RemoteException;
	public String ReservaVuelo(int cod_vuelo, String usuario, int pasajeros) throws RemoteException;
}
