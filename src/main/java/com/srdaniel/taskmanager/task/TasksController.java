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
    private ListView<TaskItem> taskListView;

    @FXML
    private TextField taskInput;

    @FXML
    private Button completeButton;

    private final ListTask listTask;

    public TasksController(Button completeButton) {
        this.completeButton = completeButton;
        listTask = new ListTask();
    }

    @FXML
    private void initialize() {
        taskListView.setItems(listTask.getTasks());

        taskListView.setCellFactory(new TaskCellFactory());

        taskListView.getStylesheets().add(Objects.requireNonNull(getClass().getResource("listTask.css")).toExternalForm());
    }

    @FXML
    private void addTask() {
        String taskTitle = taskInput.getText();
        if (!taskTitle.isEmpty()) {
            TaskItem newTask = new TaskItem(taskTitle);
            listTask.addTask(newTask);
            taskInput.clear();
        }
    }

    @FXML
    private void markAsCompleted() {
        TaskItem selectedTask = taskListView.getSelectionModel().getSelectedItem();
        if (selectedTask != null) {
            selectedTask.setCompleted(true);
        }
    }

    @FXML
    private void handleTaskClicked(MouseEvent event) {
        TaskItem selectedTask = taskListView.getSelectionModel().getSelectedItem();
        if (selectedTask != null) {
            openTaskDetailWindow(selectedTask);
        }
    }

    private void openTaskDetailWindow(TaskItem task) {
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