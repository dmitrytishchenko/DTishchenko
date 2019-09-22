package ru.job4j.io.networke;

import java.io.File;
import java.net.MalformedURLException;
import java.util.List;

public interface NetworkFileMenedger {
    List<File> getListFromRoot(String root);

    String goSubDirectory(String root);

    String goParentDirectory(String subDir);

    void downloadFile(String sourceUrl, String file) throws MalformedURLException;

    void sendFile(String file, String target);
}
