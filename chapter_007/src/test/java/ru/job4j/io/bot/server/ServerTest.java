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