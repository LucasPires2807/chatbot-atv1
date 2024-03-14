package chatbot;

import java.io.IOException;
import java.util.Objects;

public class Main {

    static int PORT_NUMBER = 60010;
    public static void main(String[] args){
        startServer();
        startClient();
    }

    public static void startServer(){
        (new Thread(() -> {
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
        })).start();
    }

    public static void startClient(){
        (new Thread(() -> {
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
        })).start();
    }
}
