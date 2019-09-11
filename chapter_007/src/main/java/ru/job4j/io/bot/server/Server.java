package ru.job4j.io.bot.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private final Socket socket;

    public Server(Socket socket) {
        this.socket = socket;
    }

    public void serverSocket() throws IOException {
        String ask = null;
        PrintWriter out = new PrintWriter(this.socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
        do {
            System.out.println("wait command ....");
            ask = in.readLine();
            System.out.println(ask);
            if ("Hello".equals(ask)) {
                out.println("Hello, dear friend, I'm oracle.");
                out.println();
            } else if ("weather".equals(ask)) {
                out.println("Today is a good day.");
                out.println();
            }
        } while (!("Exit".equals(ask)));
    }

    public static void main(String[] args) {
        try (final Socket socket = new ServerSocket(2222).accept()) {
            new Server(socket);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
