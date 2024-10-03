package com.filesharingsystem2.filesharing;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private ServerSocket serverSocket;
    private boolean running = false;

    public void start(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        running = true;
        System.out.println("Server started, waiting for connections...");

        while (running) {
            // Wacht op inkomende clientverbindingen
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected: " + clientSocket.getInetAddress());

            // Start een nieuwe thread voor elke clientverbinding
            new Thread(new ClientHandler(clientSocket)).start();
        }
    }

    public void stop() throws IOException {
        running = false;
        serverSocket.close();
    }

    // ClientHandler class to handle each client in a separate thread
    private static class ClientHandler implements Runnable {
        private Socket clientSocket;

        public ClientHandler(Socket socket) {
            this.clientSocket = socket;
        }

        @Override
        public void run() {
            try {
                // Hier kun je de logica toevoegen voor de interactie met de client
                System.out.println("Handling client: " + clientSocket.getInetAddress());

                // Voeg je bestandsuitwisselingslogica hier toe

                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
