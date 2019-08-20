package ru.job4j.io;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AnalyzeTest {
    @Test
    public void whenReadSourceThenWriteTarget() {
        Analyze analyze = new Analyze();
        String s;
        String result = "";
        String source = "C:\\projects\\DTishchenko\\chapter_007\\src\\main\\resources\\Source.txt";
        String target = "C:\\projects\\DTishchenko\\chapter_007\\src\\main\\resources\\Target.txt";
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