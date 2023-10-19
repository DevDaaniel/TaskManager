package com.srdaniel.taskmanager;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class TaskDetailController {

    @FXML
    private Label titleLabel;

    public void setTaskDetails(TaskItem task) {
        titleLabel.setText("Title: " + task.getTitle());
    }
}
