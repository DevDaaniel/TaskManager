package com.srdaniel.taskmanager;

import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

public class TaskCellFactory implements Callback<ListView<TaskItem>, ListCell<TaskItem>> {

    @Override
    public ListCell<TaskItem> call(ListView<TaskItem> param) {
        return new ListCell<>() {
            @Override
            protected void updateItem(TaskItem task, boolean empty) {
                super.updateItem(task, empty);
                if (empty || task == null) {
                    setText(null);
                } else {
                    setText(task.getTitle());
                    if (task.isCompleted()) {
                        setStyle("-fx-background-color: lightgreen;");
                    } else {
                        setStyle("-fx-background-color: white;");
                    }
                }
            }
        };
    }
}
