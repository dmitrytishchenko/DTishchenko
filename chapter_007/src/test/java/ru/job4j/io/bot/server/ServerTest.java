package ru.job4j.io.bot.server;

import com.google.common.base.Joiner;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.Socket;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
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
public class ServerTest {
    private static final String LN = System.getProperty("line.separator");

    public void testServer(String input, String expected) throws IOException {
        Socket socket = mock(Socket.class);
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        when(socket.getInputStream()).thenReturn(in);
        when(socket.getOutputStream()).thenReturn(out);
        Server server = new Server(socket);
        server.serverSocket();
        assertThat(out.toString(), is(expected));
    }

    @Test
    public void whenAskExitThenAnswerEmpty() throws IOException {
        Socket socket = mock(Socket.class);
        ByteArrayInputStream in = new ByteArrayInputStream("Exit".getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        when(socket.getInputStream()).thenReturn(in);
        when(socket.getOutputStream()).thenReturn(out);
        Server server = new Server(socket);
        server.serverSocket();
        assertThat(out.toString(), is(""));
    }

    @Test
    public void whenAskExitThenAnswerEmpty2() throws IOException {
        this.testServer("Exit", "");
    }

    @Test
    public void whenAskHelloThenAnswerImOracle() throws IOException {
        Socket socket = mock(Socket.class);
        ByteArrayInputStream in = new ByteArrayInputStream(
                Joiner.on(LN).join(
                        "Hello",
                        "Exit")
                        .getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        when(socket.getInputStream()).thenReturn(in);
        when(socket.getOutputStream()).thenReturn(out);
        Server server = new Server(socket);
        server.serverSocket();
        assertThat(out.toString(), is(
                String.format("Hello, dear friend, I'm oracle.%s%s", LN, LN)));
    }

    @Test
    public void whenAskHelloThenAnswerImOracle2() throws IOException {
        this.testServer(Joiner.on(LN).join(
                "Hello",
                "Exit"),
                String.format("Hello, dear friend, I'm oracle.%s%s", LN, LN));
    }
}