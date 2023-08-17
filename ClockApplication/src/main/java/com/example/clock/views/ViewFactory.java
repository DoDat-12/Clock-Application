package com.example.clock.views;

import com.example.clock.controllers.ClockCountdownController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewFactory {
    private static ViewFactory instance;
    private final Stage stage;
    private Scene clockCountDownScene;
    private ClockCountdownController clockCountdownController;

    private ViewFactory() {
        stage = new Stage();

        FXMLLoader clockCountdown = new FXMLLoader(getClass().getResource("/Fxml/clock-countdown.fxml"));
        try {
            clockCountDownScene = new Scene(clockCountdown.load());
            clockCountdownController = clockCountdown.getController();
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(clockCountDownScene);
        stage.setResizable(false);
        stage.setTitle("Clock");
        stage.setAlwaysOnTop(true);
        stage.show();
    }

    public static ViewFactory getInstance() {
        if (instance == null) {
            instance = new ViewFactory();
        }
        return instance;
    }

    public void routes(SCENES scene) {
        switch (scene) {
            case CLOCK_COUNTDOWN: {
                stage.setScene(clockCountDownScene);
                break;
            }
            default:
                stage.setScene(clockCountDownScene);
        }
    }

    public enum SCENES {
        CLOCK_COUNTDOWN
    }
}
