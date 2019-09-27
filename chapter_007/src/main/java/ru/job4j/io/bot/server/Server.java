package ru.job4j.io.bot.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

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
