package ru.job4j.io.chat;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

@SuppressWarnings("Duplicates")
public class ConsoleChat {
    private final String stop = "стоп";
    private final String finish = "закончить";
    private final String resume = "продолжить";

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
        int rand = new Random().nextInt(answers.length);
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new FileWriter("Query.txt"))) {
            do {
                s = reader.readLine();
                if (s.toLowerCase().equals("стоп")) {
                    stopped = true;
                } else if (s.toLowerCase().equals("продолжить")) {
                    try (Scanner console = new Scanner(System.in);
                         BufferedWriter bwriter = new BufferedWriter(new FileWriter("Query.txt"))) {
                        do {
                            s = console.nextLine();
                            if (stop.equals(s.toLowerCase())) {
                                stopped = true;
                            } else if (resume.equals(s.toLowerCase())) {
                                stopped = false;
                            }
                            if (stopped) {
                                bwriter.write(s);
                            } else {

                                writer.write(String.format("%s" + "-" + "%s", s, answers[rand]));
                                System.out.println(answers[rand]);
                            }
                        }
                        while (!s.toLowerCase().equals("закончить"));
                        writer.write(String.format("%s-%s", s, answers[rand]));
                        System.out.println(answers[rand]);
                    }
                }
            } while (finish.equals(s.toLowerCase()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ConsoleChat consoleChat = new ConsoleChat();
        consoleChat.chat();
    }
}

