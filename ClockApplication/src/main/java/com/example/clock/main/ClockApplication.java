package com.example.clock.main;
import com.example.clock.views.ViewFactory;
import javafx.application.Application;
import javafx.stage.Stage;

public class ClockApplication extends Application {
    @Override
    public void start(Stage stage) {
        ViewFactory.getInstance();
    }
    public static void main(String[] args) {
        launch();
    }
}