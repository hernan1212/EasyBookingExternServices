package google;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import gateway.IAuthentification;


public class Authentification extends UnicastRemoteObject implements IAuthentification
{
	private static final long serialVersionUID = 1L;
	private static String usuarios[][];
	
	public Authentification () throws RemoteException 
	{
		super();
	}	
	
	public static void main(String[] args) 
	
	{
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}
		registrarUsuarios();
		String name = "//" + "127.0.0.1" + ":" + "1002" + "/" + "Google";
		try 
		{		
			IAuthentification objServer = new Authentification ();
			Registry registry = LocateRegistry.createRegistry(1002);
			registry.rebind(name, (IAuthentification) objServer);
			System.out.println("* Server '" + name + "' active and waiting...");
		} 
		catch (Exception e) 
		{
			System.err.println("- Exception running the server: " + e.getMessage());
			e.printStackTrace();
		}
		

	}
	
	public boolean ComprobarUsuario(String usuario, String contrasena)
	{
		
		int x;
		
		for (x=0; x<usuarios.length; x++) 
		{
		    if (usuarios[x][0].equals(usuario))
		    {	
		    	if(usuarios[x][1].equals(contrasena))
		    	{
		    		System.out.println("Sesion iniciada");
		    		
		    		return true;
		    	}else
			    	{
			    		System.out.println("La contrasena es erronea");
			    	}
		    }else
		    {
		    	System.out.println("Usuario no encontrado");
		    }
		}
		return false;
	}
	
	private static void registrarUsuarios ()
	{
		usuarios = new String[4][];
		usuarios[0] = new String[] {"Jon", "Jon"};
		usuarios[1] = new String[] {"Julen", "Julen"};
		usuarios[2] = new String[] {"Dani", "Dani"};
		usuarios[3] = new String[] {"Raul", "Raul"};
	}


}

