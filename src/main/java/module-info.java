module com.srdaniel.taskmanager {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires java.sql;
    requires java.desktop;
    requires org.xerial.sqlitejdbc;

/*
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
*/
    opens com.srdaniel.taskmanager to javafx.fxml;
    exports com.srdaniel.taskmanager;
    exports com.srdaniel.taskmanager.auth;
    opens com.srdaniel.taskmanager.auth to javafx.fxml;
    exports com.srdaniel.taskmanager.task;
    opens com.srdaniel.taskmanager.task to javafx.fxml;
}