package org.example;

import java.io.IOException;

public class Client {
    public static void main(String[] args) {
        try (Phone phone = new Phone("127.0.0.1",8000))
        {
            System.out.println("Connected to server");
            String request = "Visaginas";

            String response = phone.readLine();
            System.out.println(response);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}