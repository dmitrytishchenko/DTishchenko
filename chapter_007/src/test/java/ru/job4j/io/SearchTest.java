package ru.job4j.io;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class SearchTest {
    @Test
    public void whenFoldersContainsFiles() {

        String parent = System.getProperty("java.io.tmpdir");

        File dir1 = new File(parent + "\\dir1");
        File dir2 = new File(parent + "\\dir1\\dir2");
        File dir3 = new File(parent + "\\dir1\\dir3");
        File dir4 = new File(parent + "\\dir1\\dir4");

        assertTrue(dir1.mkdir() || dir1.exists());
        assertTrue(dir2.mkdir() || dir1.exists());
        assertTrue(dir3.mkdir() || dir1.exists());
        assertTrue(dir4.mkdir() || dir1.exists());

        File file1 = new File(parent + "\\dir1\\file1.txt");
        File file2 = new File(parent + "\\dir1\\file2.txt");
        File file3 = new File(parent + "\\dir1\\dir2\\file3.txt");
        File file4 = new File(parent + "\\dir1\\dir3\\file4.txt");
        File file5 = new File(parent + "\\dir1\\dir4\\file5.txt");
        try {
            assertTrue(file1.createNewFile() || file1.exists());
            assertTrue(file2.createNewFile() || file2.exists());
            assertTrue(file3.createNewFile() || file3.exists());
            assertTrue(file4.createNewFile() || file4.exists());
            assertTrue(file5.createNewFile() || file5.exists());
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<File> result = new ArrayList<>();
        List<String> exts = new ArrayList<>();
        exts.add(".txt");
        result.add(file1);
        result.add(file2);
        result.add(file3);
        result.add(file4);
        result.add(file5);
        Search search = new Search();
        List<File> expected = search.files(parent, exts);
        assertThat(result, is(expected));
    }

    @Test
    public void whenFoldersContainsFiles2() {

        String parent = System.getProperty("java.io.tmpdir");

        File dir1 = new File(parent + "\\dir1");
        File dir2 = new File(parent + "\\dir1\\dir2");
        File dir3 = new File(parent + "\\dir1\\dir3");
        File dir4 = new File(parent + "\\dir1\\dir4");

        assertTrue(dir1.mkdir() || dir1.exists());
        assertTrue(dir2.mkdir() || dir1.exists());
        assertTrue(dir3.mkdir() || dir1.exists());
        assertTrue(dir4.mkdir() || dir1.exists());

        File file1 = new File(parent + "\\dir1\\file1.txt");
        File file2 = new File(parent + "\\dir1\\file2.txt");
        File file3 = new File(parent + "\\dir1\\dir2\\file3.txt");
        File file4 = new File(parent + "\\dir1\\dir3\\file4.txt");
        File file5 = new File(parent + "\\dir1\\dir4\\file5.txt");
        try {
            assertTrue(file1.createNewFile() || file1.exists());
            assertTrue(file2.createNewFile() || file2.exists());
            assertTrue(file3.createNewFile() || file3.exists());
            assertTrue(file4.createNewFile() || file4.exists());
            assertTrue(file5.createNewFile() || file5.exists());
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<File> result = new ArrayList<>();
        List<String> exts = new ArrayList<>();
        exts.add(".txt");
        result.add(file1);
        result.add(file2);
        result.add(file3);
        result.add(file4);
        result.add(file5);
        Search search = new Search();
        List<File> expected = search.files2(parent, exts, result);
        assertThat(result, is(expected));
    }
}