package ru.job4j.io;

import org.junit.Test;

import java.io.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AnalyzeTest {
    @Test
    public void whenReadSourceThenWriteTarget() {
        Analyze analyze = new Analyze();
        String s;
        String serverLog = "200 10:56:01\n"
                + "500 10:57:01\n"
                + "400 10:58:01\n"
                + "200 10:59:01\n"
                + "500 11:01:02\n"
                + "200 11:02:02";
        String result = "";
        String parent = System.getProperty("java.io.tmpdir") + File.separator;
        File file = new File(parent + "Source");
        File file1 = new File(parent + "Target");
        try (FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.write(serverLog);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String source = file.getAbsolutePath();
        String target = file1.getAbsolutePath();
        analyze.unavailable(source, target);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File(target)));
            while ((s = reader.readLine()) != null) {
                result += s;
            }
            assertThat(result, is("10:57:01-10:59:0111:01:02-11:02:02"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}