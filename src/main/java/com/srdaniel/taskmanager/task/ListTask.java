package com.srdaniel.taskmanager.task;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ListTask {
    private final ObservableList<TaskItem> tasks = FXCollections.observableArrayList();

    public void addTask(TaskItem task) {
        tasks.add(task);
    }

    public void removeTask(TaskItem task) {
        tasks.remove(task);
    }

    public ObservableList<TaskItem> getTasks() {
        return tasks;
    }
}
