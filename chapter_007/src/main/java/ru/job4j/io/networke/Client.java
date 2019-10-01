package ru.job4j.io.networke;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Client {
    private final Socket socket;

    public Client(Socket socket) {
        this.socket = socket;
    }

    public void runClient() throws IOException {
        PrintWriter out = new PrintWriter(this.socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
        Scanner console = new Scanner(System.in);
        List<String> requests = new ArrayList<>();
        requests.add("список корневого каталога");
        requests.add("перейти в подкаталог");
        requests.add("спуститься в родительский каталог");
        requests.add("скачать файл");
        requests.add("загрузить файл");
        for (String req : requests) {
            out.write(req);
        }
    }

    public static void main(String[] args) {
        ConfigSockets config = new ConfigSockets();
        try (Socket socket = new Socket(config.get("IP"), Integer.valueOf(config.get("PORT")))) {
            new Client(socket).runClient();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
