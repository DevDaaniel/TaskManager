package com.srdaniel.taskmanager;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ListTask {
    private ObservableList<TaskItem> tasks = FXCollections.observableArrayList();

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
