package chatbot;

import java.io.*;
import java.net.Socket;
import java.util.Objects;

public class Cliente {

    private static Socket socket;
    private static BufferedReader keyboardInput;
    private static BufferedReader serverAnswer;
    private static PrintWriter clientAnswer;

    public static void connect(int port) throws IOException {
        socket = new Socket("localhost", port);
        initializeStreamVariables();
    }

    private static void initializeStreamVariables() throws IOException {
        keyboardInput = new BufferedReader(new InputStreamReader(System.in));
        clientAnswer = new PrintWriter(socket.getOutputStream(), true);
        serverAnswer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    public static String sendMessage() throws IOException {
        String str = keyboardInput.readLine();
        clientAnswer.println(str);
        return str;
    }

    public static void readMessage() throws IOException {
        System.out.println(serverAnswer.readLine());
    }

    public static void closeConnection() throws IOException {
        clientAnswer.close();
        keyboardInput.close();
        socket.close();
    }

}