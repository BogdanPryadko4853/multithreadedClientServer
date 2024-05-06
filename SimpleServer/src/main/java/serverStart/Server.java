package serverStart;

import org.example.Phone;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {

    public static void main(String[] args) {

        try (ServerSocket serverSocket = new ServerSocket(8000)) {
            System.out.println("Server started" + serverSocket);

            while (true)
                try (Phone phone = new Phone(serverSocket)) {
                    String request = phone.readLine();
                    String response = (int)(Math.random()*30 - 10)+ "";
                    phone.writeLine(response);
                }catch (NullPointerException e) {
                    e.printStackTrace();
                }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
