package ru.job4j.io.chat;

import java.io.*;
import java.util.Random;

@SuppressWarnings("Duplicates")
public class ConsoleChat {

    public void chat() {
        String s;
        boolean stopped = false;
        String[] answers = new String[]{"Здравствуйте", "Как Ваши дела", "Ваше обращение очень важно для нас", "Счастливого пути"};
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new FileWriter("Query.txt"))) {
            while (!(s = reader.readLine()).toLowerCase().equals("закончить")) {
                if (s.toLowerCase().equals("стоп")) {
                    stopped = true;
                } else if (s.toLowerCase().equals("продолжить")) {
                    stopped = false;
                }
                if (stopped) {
                    writer.write(s);
                } else {
                    int rand = new Random().nextInt(answers.length);
                    writer.write(String.format("%s" + "-" + "%s", s, answers[rand]));
                    System.out.println(answers[rand]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void chat2() {
        String s;
        boolean stopped = false;
        String[] answers = new String[]{"Здравствуйте", "Как Ваши дела", "Ваше обращение очень важно для нас", "Счастливого пути"};
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new FileWriter("Query.txt"))) {
            do {
                s = reader.readLine();
                if (s.toLowerCase().equals("стоп")) {
                    stopped = true;
                } else if (s.toLowerCase().equals("продолжить")) {
                    stopped = false;
                }
                if (stopped) {
                    writer.write(s);
                } else {
                    int rand = new Random().nextInt(answers.length);
                    writer.write(String.format("%s" + "-" + "%s", s, answers[rand]));
                    System.out.println(answers[rand]);
                }
            }
            while (!s.toLowerCase().equals("закончить"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ConsoleChat consoleChat = new ConsoleChat();
        consoleChat.chat();
    }
}
