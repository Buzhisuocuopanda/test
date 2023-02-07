package com.example.csd.TCP;

import java.io.IOException;
import java.net.Socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class TCPClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 8888);
        DataInputStream inputStream = new DataInputStream(socket.getInputStream());
        DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());

        outputStream.writeUTF("Hello from the client!");

        String response = inputStream.readUTF();
        System.out.println("Received response: " + response);

        inputStream.close();
        outputStream.close();
        socket.close();
    }
}
