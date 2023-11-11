package com.chris.javabasics.jucpatterns.threadpermessage.webserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MiniServer {
    private final int portnumber;

    public MiniServer(int portnumber) {
        this.portnumber = portnumber;
    }

    public void execute() {
        // Thread-Per-Message模式
        ExecutorService executorService = Executors.newCachedThreadPool();

        try ( ServerSocket serverSocket = new ServerSocket(portnumber);) {
            System.out.println("Listening on " + serverSocket);
            while (true) {
                System.out.println("Accepting...");

                final Socket clientSocket = serverSocket.accept();

                System.out.println("Connected to " + clientSocket);

                // Thread-Per-Message模式
                executorService.execute(
                        () -> {
                            try {
                                Service.service(clientSocket);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                );
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Thread-Per-Message模式
            executorService.shutdown();
        }
    }
}
