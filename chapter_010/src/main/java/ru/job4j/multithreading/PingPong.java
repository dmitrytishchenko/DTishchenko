package ru.job4j.multithreading;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class PingPong extends Application {
    private static final String JOB4J = "Пинг-понг www.job4j.ru";

    @Override
    public void start(Stage stage) {
        int limitX = 300;
        int limitY = 300;
        Group group = new Group();
        Rectangle rect = new Rectangle(0, 150, 10, 10);
        group.getChildren().add(rect);
        Thread thread = new Thread(new RectangleMove(rect));
        thread.start();
        stage.setScene(new Scene(group, limitX, limitY));
        stage.setOnCloseRequest(event -> {
            thread.interrupt();
        });
        stage.setTitle(JOB4J);
        stage.setResizable(false);
        stage.show();
    }
}
