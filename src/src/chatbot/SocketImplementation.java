package chatbot;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketImplementation {

    private ServerSocket serverSocket;
    private Socket socket;
    private PrintWriter output;
    private BufferedReader input;

    public Socket initializeAndConnect(int port) throws IOException {
        serverSocket = new ServerSocket(400);
        socket = serverSocket.accept();
        initializeCommunication();
        return socket;
    }

    private void initializeCommunication() throws IOException {
        output = new PrintWriter(socket.getOutputStream(), true);
        input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    public void recieveMessage(){

    }

    public void closeConnection() throws IOException {
        input.close();
        output.close();
        serverSocket.close();
        socket.close();
    }

}
