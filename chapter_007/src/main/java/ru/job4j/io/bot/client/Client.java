package ru.job4j.io.bot.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * 1. Создать бот - мудрый Оракл.
 * 2. Серверная сторона.
 * Socket socket =  new ServerSocket(port).accept();
 * PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
 * BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
 * do {
 * System.out.println("wait command ...");
 * String ask = in.readLine();
 * System.out.println(ask);
 * if ("hello".equals(ask)) {
 * out.println("Hello, dear friend, I'm a oracle.");
 * out.println();
 * }
 * } while ("exit".equals(ask));
 * Сервер должен отвечать на простые вопросы. Если Оралку сказали пока. То приложение выключается.
 * 3. Клиент.
 * Socket socket = new Socket(InetAddress.getByName(ip), port);
 * PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
 * BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
 * Scanner console = new Scanner(System.in);
 * do {
 * out.println("Hello oracle");
 * String str;
 * while (!(str = in.readLine()).isEmpty()) {
 * System.out.println(str);
 * }
 * } while ()
 * 4. Важно. что Оракл может отправлять большие сообщения. Что бы понять когда конец сообщение он отправляет пустую строку.
 * 5. Обязательно напишите тесты https://www.youtube.com/watch?v=YEZx_Bz_OPA
 */

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
