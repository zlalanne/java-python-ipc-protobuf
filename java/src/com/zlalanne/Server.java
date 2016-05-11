package com.zlalanne;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

import com.zlalanne.Message.Command;

public class Server {

    final private int PORT = 9999;
    private ServerSocket serverSocket;

    public Server() {
        try {
            serverSocket = new ServerSocket(PORT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        boolean running = true;

        try {
            System.out.println("Waiting for connection on port " + PORT);
            Socket clientSocket = serverSocket.accept();
            System.out.println("Connection established. Waiting for messages...");
            OutputStream os = clientSocket.getOutputStream();
            InputStream is = clientSocket.getInputStream();

            while(running) {

                Command cmd = Command.parseDelimitedFrom(is);

                switch(cmd.getType()) {
                    case START_TEST: {
                        // Process Start_TEST
                        System.out.println("Processing START_TEST");
                        System.out.println("Running test " + cmd.getName());
                        break;
                    }
                    case SHUTDOWN: {
                        System.out.println("Stopping the server...");
                        running = false;
                        break;
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
