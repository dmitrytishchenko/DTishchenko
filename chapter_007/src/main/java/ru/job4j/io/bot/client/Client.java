package ru.job4j.io.bot.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private final Socket socket;

    public Client(Socket socket) {
        this.socket = socket;
    }

    public void clientSocket() throws IOException {
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        Scanner console = new Scanner(System.in);
        String str;
        boolean runChat = true;
        do {
            out.println("Hello oracle");
            while (!(str = in.readLine()).isEmpty()) {
                System.out.println(str);
                if ("Hello".equals(str)) {
                    out.println("What is the weather.");
                    out.println();
                } else if ("Exit".equals(str)) {
                    runChat = false;
                    break;
                }
            }
        } while (runChat);
    }

    public static void main(String[] args) {
        try (Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 2222)) {
            new Client(socket).clientSocket();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
