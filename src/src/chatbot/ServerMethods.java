package chatbot;

import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;

public class ServerMethods extends UnicastRemoteObject implements IServerRMI {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String message = null;
	
	protected ServerMethods() throws RemoteException {
		super();
	}

	@Override
	public void recieveMessage(String message) throws RemoteException {
		System.out.println("Message recieved: " + message);
		this.message = message;
	}

	@Override
	public String sendMessage() throws RemoteException {
		return message;
	}

}
