package chatbot;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Objects;

public class SocketImplementation {

    private static ServerSocket serverSocket;
    private static Socket socket;
    private static PrintWriter output;
    private static BufferedReader input;


    public static void connect(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        socket = serverSocket.accept();
        initializeStreamVariables();
    }

    private static void initializeStreamVariables() throws IOException {
        output = new PrintWriter(socket.getOutputStream(), true);
        input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    public static String recieveMessage() throws IOException {
        String str = input.readLine();
        output.println(str);
        return str;
    }

    public static void closeConnection() throws IOException {
        input.close();
        output.close();
        serverSocket.close();
        socket.close();
    }

}
