package chatbot;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IServerRMI extends Remote {
	void recieveMessage(String message) throws RemoteException;
	String sendMessage() throws RemoteException;
}
