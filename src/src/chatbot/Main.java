package chatbot;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Cliente cliente = new Cliente();
        SocketImplementation server = new SocketImplementation();

        try{
            server.initializeAndConnect(400);
            cliente.connect(400);
        } catch (Exception e){
            System.err.println(e);
        }

        cliente.sendMessage();
        server.recieveMessage();

        cliente.closeConnection();
        server.closeConnection();

    }
}
