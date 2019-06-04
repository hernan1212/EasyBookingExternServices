package airline;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import gateway.IAirline;

public class Airline extends UnicastRemoteObject implements IAirline 
{
	private static List<Flight> listavuelos = new ArrayList<Flight>();
	private static int cod=0;
	
		final long serialVersionUID = 1L;
		
		protected Airline() throws RemoteException 
		{
			super();
		}	
		
		public static void main(String[] args) 
		
		{
			if (System.getSecurityManager() == null) {
				System.setSecurityManager(new SecurityManager());
			}
			String name = "//" + "127.0.0.1" + ":" + 1003 + "/" + "Iberia";
			try 
			{		
				IAirline objServer = new Airline ();
				Registry registry = LocateRegistry.createRegistry(1003);
				registry.rebind(name, (IAirline) objServer);
				System.out.println("* Server '" + name + "' active and waiting...");
			} 
			catch (Exception e) 
			{
				System.err.println("- Exception running the server: " + e.getMessage());
				e.printStackTrace();
			}
			
			registrarVuelos();
		}
	
	
	public List<Flight> BuscarVuelos(String origen, String destination, String fecha, int passenger) 
	{
		List<Flight> copia = new ArrayList<Flight>();
		copia=null;
		 Flight aux = new Flight();
		
		for(int i=0; i<listavuelos.size(); i++)
		{
			aux=listavuelos.get(i);
			if(aux.getDeparture().getPlace().equals(origen)
				&& aux.getArrival().getPlace().equals(destination) 
				&& aux.getDeparture_date().equals(fecha) 
				&& aux.getTotal_seats()>passenger)
			{
				copia.add(listavuelos.get(i));
			}
			
		}
		return copia;
	}
	
	public List<Flight> BuscarTodoVuelos() 
	{
		return listavuelos;
	}
	
	public String ReservaVuelo(int cod_vuelo, String usuario, int pasajeros) 
	{
		String codigo;
		Flight aux = new Flight();
		
		for(int i=0; i<listavuelos.size(); i++)
		{
			aux=listavuelos.get(i);
			if(aux.getFlight_number()== cod_vuelo
				&& aux.getTotal_seats()> pasajeros)
			{
			listavuelos.remove(i);
			aux.setTotal_seats(aux.getTotal_seats()- pasajeros);
			listavuelos.add(aux);
			
			codigo= cod+"_"+usuario+pasajeros+"_"+cod_vuelo;
			cod++;
			return codigo;
			}
			
		}
		return null;
	}
	
	public static void registrarVuelos()
	{
		Airport Londres = new Airport(1, "Londres");
		Airport Madrid = new Airport(2, "Madrid");
		Airport Roma = new Airport(3, "Roma");
		
		Flight vuelo1= new Flight(1, "1-05-2019", "1-05-2019", 34, 120, null, Londres, Madrid);
		Flight vuelo2= new Flight(2, "4-07-2019", "4-07-2019", 40, 20, null, Madrid, Londres);
		Flight vuelo3= new Flight(3, "3-06-2019", "3-06-2019", 40, 49, null, Roma, Madrid);
		Flight vuelo4= new Flight(4, "2-05-2019", "2-05-2019", 40, 10, null, Madrid,Roma);
		Flight vuelo5= new Flight(5, "5-05-2019", "5-05-2019", 50, 1000, null, Londres,Roma);
		listavuelos.add(vuelo1);
		listavuelos.add(vuelo2);
		listavuelos.add(vuelo3);
		listavuelos.add(vuelo4);
		listavuelos.add(vuelo5);
	}
}



