package com.srdaniel.taskmanager.task;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class TasksController {

    @FXML
    public ListView<TaskItem> taskListView;

    @FXML
    public TextField taskInput;

    @FXML
    public Button completeButton;

    public final ListTask listTask;

    public TasksController(Button completeButton) {
        this.completeButton = completeButton;
        listTask = new ListTask();
    }

    @FXML
    public void initialize() {
        taskListView.setItems(listTask.getTasks());

        taskListView.setCellFactory(new TaskCellFactory());

        taskListView.getStylesheets().add(Objects.requireNonNull(getClass().getResource("listTask.css")).toExternalForm());
    }

    @FXML
    public void addTask() {
        String taskTitle = taskInput.getText();
        if (!taskTitle.isEmpty()) {
            TaskItem newTask = new TaskItem(taskTitle);
            listTask.addTask(newTask);
            taskInput.clear();
        }
    }

    @FXML
    public void markAsCompleted() {
        TaskItem selectedTask = taskListView.getSelectionModel().getSelectedItem();
        if (selectedTask != null) {
            selectedTask.setCompleted(true);
        }
    }

    @FXML
    public void handleTaskClicked(MouseEvent event) {
        TaskItem selectedTask = taskListView.getSelectionModel().getSelectedItem();
        if (selectedTask != null) {
            openTaskDetailWindow(selectedTask);
        }
    }

    public void openTaskDetailWindow(TaskItem task) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("TaskDetailView.fxml"));
            Parent root = loader.load();

            TaskDetailController detailController = loader.getController();
            detailController.setTaskDetails(task);

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Task Details");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}