package com.example.clock.services;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.util.Duration;

public class CountdownTimer {
    private final Label label_hour;
    private final Label label_minute;
    private final Label label_second;
    private int hour;
    private int minute;
    private int second;
    private Timeline timeline;

    // Constructor
    public CountdownTimer(Label label_hour, Label label_minute, Label label_second) {
        this.label_hour = label_hour;
        this.label_minute = label_minute;
        this.label_second = label_second;
    }

    // Start Counting
    public void CountingDown(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;

        this.label_hour.setText(formatNumber(this.hour));
        this.label_minute.setText(formatNumber(this.minute));
        this.label_second.setText(formatNumber(this.second));

        if (timeline != null) {
            timeline.stop();
        }

        timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
            this.second--;
            if (this.second < 0) {
                this.second = 59;
                this.minute--;
                if (this.minute < 0) {
                    this.minute = 59;
                    this.hour--;
                }
            }

            this.label_hour.setText(formatNumber(this.hour));
            this.label_minute.setText(formatNumber(this.minute));
            this.label_second.setText(formatNumber(this.second));
        }));

        timeline.setCycleCount(this.hour*3600 + this.minute*60 + this.second);
        timeline.setOnFinished(event -> {

        });
        timeline.play();
    }

    // TODO: Counting session

    // Format Number
    private String formatNumber(int number) {
        if (number >= 10)
            return String.valueOf(number);
        else
            return "0" + String.valueOf(number);
    }
}
