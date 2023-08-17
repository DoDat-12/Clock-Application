package com.example.clock.controllers;

import com.example.clock.services.CountdownTimer;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class ClockCountdownController implements Initializable {
    @FXML
    private Label label_hour;
    @FXML
    private Label label_minute;
    @FXML
    private Label label_second;

    private CountdownTimer countdownTimer;
    private int hour;
    private int minute;
    private int second;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.hour = 1;
        this.minute = 0;
        this.second = 0;
        countdownTimer = new CountdownTimer(label_hour, label_minute, label_second);
        countdownTimer.CountingDown(this.hour, this.minute, this.second);
    }

    private void runTimer() {
        countdownTimer.CountingDown(hour, minute, second);
    }
}