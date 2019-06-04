package paypal;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import gateway.IPayment;

public class PayPal extends UnicastRemoteObject implements IPayment 
{
	private static final long serialVersionUID = 1L;
	private static String usuarios[][];
	private int codigo = 0;
	
	protected PayPal () throws RemoteException 
	{
		super();
	}	
	
	public static void main(String[] args) 
	
	{
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}
		String name = "//" + "127.0.0.1" + ":" + "1001" + "/" + "PayPal";
		try 
		{		
			IPayment objServer = new PayPal ();
			Registry registry = LocateRegistry.createRegistry(1001);
			registry.rebind(name, (IPayment) objServer);
			System.out.println("* Server '" + name + "' active and waiting...");
		} 
		catch (Exception e) 
		{
			System.err.println("- Exception running the server: " + e.getMessage());
			e.printStackTrace();
		}
		
		registrarUsuarios();
	}
	
	public String PagoReserva(String user, int Precio)
	{
		int x;
		int saldo;
		String Stringcodigo = null;
		
		for (x=0; x<usuarios.length; x++) 
		{
		    if (usuarios[x][0].equals(user))
		    {
		    	saldo = Integer.parseInt(usuarios[x][2]);
		    		
		    		if (Precio>saldo)
			    	{
			    		System.out.println("Error. Saldo insuficiente");
			    	}
			    	else
			    	{
			    		saldo = saldo-Precio;
			    		usuarios[x][2]=String.valueOf(saldo);
			    		System.err.println("pago realizado");
			    		codigo++;		    		
			    		Stringcodigo = String.valueOf(codigo);
			    		return Stringcodigo;
			    	}
		    	}
		}   
		System.out.println("Error. Usuario no encontrado");
		return Stringcodigo; 
	}
	
	private static void registrarUsuarios ()
	{
		usuarios = new String[4][];
		usuarios[0] = new String[] {"Jon", "Jon", "10000"};
		usuarios[1] = new String[] {"Julen", "Julen", "10000"};
		usuarios[2] = new String[] {"Dani", "Dani", "10000"};
		usuarios[3] = new String[] {"Raul", "Raul", "10000"};
	}


}
