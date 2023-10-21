package com.srdaniel.taskmanager.task;

public class TaskItem {
    private final String title;
    private boolean completed;

    public TaskItem(String title) {
        this.title = title;
        this.completed = false;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
