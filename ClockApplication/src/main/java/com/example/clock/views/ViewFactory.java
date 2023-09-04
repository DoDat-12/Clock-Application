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

        // Listing All FXMLLoaders
        FXMLLoader clockCountdown = new FXMLLoader(getClass().getResource("/Fxml/clock-countdown.fxml"));

        try {
            // Creating all scenes & their controllers
            clockCountDownScene = new Scene(clockCountdown.load());
            clockCountdownController = clockCountdown.getController();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Stage setting procedure
        stage.setScene(clockCountDownScene);
        stage.setResizable(false);
        stage.setTitle("Yuri's Clock");
        stage.setAlwaysOnTop(true);
        stage.show();
    }

    // Get Instance
    public static ViewFactory getInstance() {
        if (instance == null) {
            instance = new ViewFactory();
        }
        return instance;
    }

    // SCENES Select
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

    // SCENES Menu
    public enum SCENES {
        CLOCK_COUNTDOWN
    }
}
