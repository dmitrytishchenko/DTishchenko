package ru.job4j.odd.testt;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        CrossZero cr = new CrossZero(3);
        cr.startCompToComp();
    }
}
