module com.srdaniel.taskmanager {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

/*
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
*/
    opens com.srdaniel.taskmanager to javafx.fxml;
    exports com.srdaniel.taskmanager;
}