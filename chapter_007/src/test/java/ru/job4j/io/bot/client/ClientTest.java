package ru.job4j.io.bot.client;

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

public class ClientTest {
    private static final String LN = System.getProperty("line.separator");

    @Test
    public void whenAskHelloOracleThenAnswerWhatIsTheWeather() throws IOException {
        Socket socket = mock(Socket.class);
        ByteArrayInputStream in = new ByteArrayInputStream(
                Joiner.on(LN).join(
                        "Hello",
                        "Exit")
                        .getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        when(socket.getInputStream()).thenReturn(in);
        when(socket.getOutputStream()).thenReturn(out);
        Client client = new Client(socket);
        client.clientSocket();
        assertThat(out.toString(), is(
                String.format("Hello oracle%sWhat is the weather.%s%s", LN, LN, LN)));
    }

    public void testClient(String input, String output) throws IOException {
        Socket socket = mock(Socket.class);
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        when(socket.getInputStream()).thenReturn(in);
        when(socket.getOutputStream()).thenReturn(out);
        Client client = new Client(socket);
        client.clientSocket();
        assertThat(out.toString(), is(output));
    }

    @Test
    public void whenAskHelloOracleThenAnswerWhatIsTheWeather2() throws IOException {
        testClient(
                Joiner.on(LN).join(
                        "Hello",
                        "Exit"),
                String.format("Hello oracle%sWhat is the weather.%s%s", LN, LN, LN));
    }
}
