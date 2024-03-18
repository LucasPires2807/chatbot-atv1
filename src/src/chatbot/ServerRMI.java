package chatbot;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class ServerRMI {
	
	public ServerRMI(int port) throws RemoteException, MalformedURLException, AlreadyBoundException {
		IServerRMI server = new ServerMethods();
		System.setProperty( "java.rmi.server.hostname", "192.168.0.215" );
		String objName = "rmi://192.168.0.215/server";
		LocateRegistry.createRegistry(port);
		Naming.rebind(objName, server);
	}
}
