package ru.job4j.io.networke;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

public class ServerTest {

    @Test
    public void getListFromRoot() {
        String root = System.getProperty("java.io.tmpdir") + File.separator;
        Socket socket = mock(Socket.class);
        File file = new File(root);
        List<File> result = new ArrayList<>();
        for (File f : file.listFiles()) {
            result.add(f);
        }
        List<File> expected = new Server(socket, root).getListFromRoot(root);
        assertThat(result, is(expected));
    }

    @Test
    public void goToSubDir() {
        String root = System.getProperty("java.io.tmpdir") + File.separator;
        String result = null;
        String expected;
        Socket socket = mock(Socket.class);
        File file = new File(root);
        for (File f : file.listFiles()) {
            if (f.isDirectory()) {
                result = f.getAbsolutePath();
                break;
            }
        }
        expected = new Server(socket, root).goSubDirectory(root);
        assertThat(result, is(expected));
    }

    @Test
    public void goToParent() {
        String root = System.getProperty("java.io.tmpdir");
        Socket socket = mock(Socket.class);
        String subDir = new Server(socket, root).goSubDirectory(root);
        String result = new Server(socket, root).goParentDirectory(subDir) + File.separator;
        assertThat(result, is(root));
    }

    @Test
    public void downloadFile() throws IOException {
        String root = System.getProperty("java.io.tmpdir");
        File file1 = new File(root + File.separator + "File1.txt");
        File file2 = new File(root + File.separator + "File2.txt");
        file1.createNewFile();
        file2.createNewFile();
        Socket socket = mock(Socket.class);
        new Server(socket, root).downloadFile2(file1.getPath(), file2.getPath());
        assertThat(file1.length(), is(file2.length()));
    }
}