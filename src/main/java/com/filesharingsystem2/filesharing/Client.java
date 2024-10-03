package com.filesharingsystem2.filesharing;

import java.io.IOException;
import java.net.Socket;

public class Client {
    private Socket socket;

    public void start(String serverAddress, int port) throws IOException {
        socket = new Socket(serverAddress, port);
        System.out.println("Connected to server: " + serverAddress);

        // Hier kun je de logica toevoegen voor de bestandsoverdracht naar de server

        socket.close();
    }
}

