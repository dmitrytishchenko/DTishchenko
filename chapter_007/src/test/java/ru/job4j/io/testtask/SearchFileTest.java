package ru.job4j.io.testtask;

import org.junit.Test;

import java.io.File;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class SearchFileTest {
    @Test
    public void getFileTest() {
        String parentDir = "C:\\projects\\DTishchenko\\chapter_007\\src\\main\\java\\ru\\job4j\\io";
        SearchFile sf = new SearchFile();
        List<File> result = sf.getFile(parentDir);
        System.out.println(result.size());
        assertThat(result.size(), is(15));
    }

}