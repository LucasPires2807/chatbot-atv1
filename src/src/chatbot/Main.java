package chatbot;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Objects;

public class Main {

    static int PORT_NUMBER = 60010;
    static String CONNECTION_TYPE = "rmi";
    public static void main(String[] args){
        startServer(CONNECTION_TYPE);
        startClient(CONNECTION_TYPE);
    }

    public static void startServer(String connectionType){
        (new Thread(() -> {
        	if(Objects.equals("socket", connectionType)) {
        		try {
                    SocketImplementation.connect(PORT_NUMBER);
                    String str = "";
                    while(!Objects.equals(str, "q")){
                        str = SocketImplementation.recieveMessage();
                    }
                    SocketImplementation.closeConnection();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
        	}
        	else if(Objects.equals("rmi", connectionType)) {
        		try {
					ServerRMI server = new ServerRMI(PORT_NUMBER);
				} catch (RemoteException | MalformedURLException e) {
					e.printStackTrace();
				} catch (AlreadyBoundException e) {
					e.printStackTrace();
				}
        	}
        })).start();
    }

    public static void startClient(String connectionType){
        (new Thread(() -> {
        	if(Objects.equals("socket", connectionType)) {
        		try{
                    Cliente.connect(PORT_NUMBER);
                    String str = "";
                    while(!Objects.equals(str, "q")){
                        str = Cliente.sendMessage();
                        Cliente.readMessage();
                    }
                    Cliente.closeConnection();
                } catch(IOException e){
                    throw new RuntimeException(e);
                }
        	}
        	else if(Objects.equals("rmi", connectionType)) {
    			ClienteRMI cliente;
				try {
					cliente = new ClienteRMI(PORT_NUMBER);
	        		System.out.println("Ola");
					cliente.sendMessage();
					System.out.println(cliente.outputMessage());
				} catch (NotBoundException | IOException e) {
					e.printStackTrace();
				}
        	}
        })).start();
    }
}
