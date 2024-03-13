package chatbot;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

    private Socket socket;
    private Scanner scanner;
    private PrintStream output;

    public Cliente(){
    }

    public Socket connect(int port) throws IOException {
        socket = new Socket("localhost", port);
        initializeCommunication();
        return socket;
    }

    public Socket getSocket() {
        return socket;
    }

    private void initializeCommunication() throws IOException {
        output = new PrintStream(socket.getOutputStream());
        scanner = new Scanner(System.in);
    }

    public void sendMessage() throws IOException {
        output.write(scanner.nextLine().getBytes());
    }

    public void closeConnection() throws IOException {
        output.close();
        scanner.close();
        socket.close();
    }
}