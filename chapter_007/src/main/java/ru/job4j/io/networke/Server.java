package ru.job4j.io.networke;

import java.io.*;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Server implements NetworkFileMenedger {
    private final Socket socket;
    private final String listFiles = "список корневого каталога";
    private final String subDir = "перейти в подкаталог";
    private final String parentDir = "спуститься в родительский каталог";
    private final String downloadFile = "скачать файл";
    private final String sendFile = "загрузить файл";
    private String subDirectory = null;
    private String sourceUrl = null;
    private String file = null;
    private String target = null;
    private String root;

    public Server(Socket socket, String root) {
        this.socket = socket;
        this.root = root;
    }

    public void runServer() throws IOException {
        String ask = null;
        PrintWriter out = new PrintWriter(this.socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
        while ((ask = in.readLine()) != null) {
            Server server = new Server(new Socket(), this.root);
            if (listFiles.equals(ask)) {
                server.getListFromRoot(this.root);
            } else if (subDir.equals(ask)) {
                subDirectory = server.goSubDirectory(this.root);
            } else if (parentDir.equals(ask)) {
                server.goParentDirectory(subDirectory);
            } else if (downloadFile.equals(ask)) {
                server.downloadFile(sourceUrl, file);
            } else if (sendFile.equals(ask)) {
                server.sendFile(file, target);
            }
        }
    }

    public List<File> getListFromRoot(String root) {
        List<File> result = new ArrayList<>();
        File file = new File(root);
        for (File f : file.listFiles()) {
            result.add(f);
        }
        return result;
    }

    public String goSubDirectory(String root) {
        String result = null;
        File file = new File(root);
        if (file.isDirectory()) {
            for (File f : file.listFiles()) {
                if (f.isDirectory()) {
                    result = f.getAbsolutePath();
                    break;
                }
            }
        }
        return result;
    }

    public String goParentDirectory(String subDir) {
        String result = null;
        File file = new File(subDir);
        result = file.getParent();
        return result;
    }

    public void downloadFile(String sourceUrl, String file) throws MalformedURLException {
        URL url = new URL(sourceUrl);
        try (BufferedInputStream bis = new BufferedInputStream(url.openStream());
             FileOutputStream fos = new FileOutputStream(file)) {
            int count;
            while ((count = bis.read()) != -1) {
                fos.write(count);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void downloadFile2(String source, String target) {
        try (FileInputStream fis = new FileInputStream(source);
             FileOutputStream fos = new FileOutputStream(target)) {
            byte[] buffer = new byte[8192];
            int size;
            while ((size = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, size);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendFile(String file, String target) {
        try (FileInputStream fis = new FileInputStream(file);
             FileOutputStream fos = new FileOutputStream(target);
             BufferedOutputStream bos = new BufferedOutputStream(fos)) {
            int count;
            while ((count = fis.read()) != -1) {
                bos.write(count);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try (Socket socket = new ServerSocket(Integer.valueOf(new ConfigSockets().get("PORT"))).accept()) {
            new Server(socket, "C:\\projects\\DTishchenko\\chapter_007\\src\\main\\java\\ru\\job4j\\io\\networke").runServer();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
