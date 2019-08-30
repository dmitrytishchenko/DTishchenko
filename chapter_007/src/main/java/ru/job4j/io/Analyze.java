package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Analyze {
    public void unavailable(String source, String target) {
        List<String> list = new ArrayList<>();
        String s = null;
        String endTime = null;
        boolean works = true;
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(source)));
             BufferedWriter writer = new BufferedWriter(new FileWriter(new File(target)))) {
            while ((s = reader.readLine()) != null) {
                String[] mas = s.split(" ");
                if (mas[0].startsWith("400") || mas[0].startsWith("500") || !works) {
                    list.add(mas[1]);
                    works = false;
                  if (mas[0].startsWith("200") || mas[0].startsWith("300") && works) {
                      endTime = mas[1];
                      works = true;
                      writer.write(list.get(0) + "-" +  endTime);
                      writer.write("\n");
                      list.clear();
                  }
                 }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try (PrintWriter out = new PrintWriter(new FileOutputStream("unavailable.csv"))) {
            out.println("15:01:30;15:02:32");
            out.println("15:10:30;23:12:32");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
