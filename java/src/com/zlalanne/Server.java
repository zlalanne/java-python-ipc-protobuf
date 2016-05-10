package com.zlalanne;

import com.zlalanne.Message.Command.CommandType;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

import static com.zlalanne.Message.Command.CommandType.START_TEST;

public class Server {

    final private int PORT = 9999;
    private ServerSocket serverSocket;

    public Server() {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        boolean running = true;

        Message.Command.Builder command  = Message.Command.newBuilder();

        try {
            Socket clientSocket = serverSocket.accept();
            OutputStream os = clientSocket.getOutputStream();
            InputStream is = clientSocket.getInputStream();

            while(running) {
                command.mergeFrom(is);

                switch(command.getType()) {
                    case START_TEST: {
                        // Process Start_TEST
                        System.out.println("Processing START_TEST");
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
