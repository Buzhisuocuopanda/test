package com.example.csd.TCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("Server Started...");

        while (true) {
            Socket socket = serverSocket.accept();
            DataInputStream inputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());

            String message = inputStream.readUTF();
            System.out.println("Received message: " + message);

            outputStream.writeUTF("ACK: " + message);

            inputStream.close();
            outputStream.close();
            socket.close();
        }
    }
}
