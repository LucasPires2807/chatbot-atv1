package chatbot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class ClienteRMI {
	
	private BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	private String clientRequest = null;
	private String objName = "";
	private IServerRMI server = null;
	
	public ClienteRMI(int port) throws MalformedURLException, RemoteException, NotBoundException {
		objName = "rmi://192.168.0.215:" + port + "/server";
		server = (IServerRMI) Naming.lookup(objName);
	}
	
	public void sendMessage() throws IOException {
		clientRequest = bufferedReader.readLine();
		server.recieveMessage(clientRequest);
	}
	
	public String outputMessage() throws RemoteException {
		return server.sendMessage();
	}
	
}
