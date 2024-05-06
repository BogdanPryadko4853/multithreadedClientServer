package org.example;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try (Socket socket = new Socket("127.0.0.1", 8000);
             BufferedWriter writer =
                     new BufferedWriter(
                             new OutputStreamWriter(
                                     socket.getOutputStream()));

             BufferedReader bufferedReader =
                     new BufferedReader(
                             new InputStreamReader(
                                     socket.getInputStream()));) {

            System.out.println("Connected to server");
            String request = "Visaginas";
            writer.write(request);
            writer.newLine();
            writer.flush();

            String response = bufferedReader.readLine();
            System.out.println(response);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}