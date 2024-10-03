module com.filesharingsystem2.filesharing {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires org.kordamp.ikonli.javafx;
    requires eu.hansolo.tilesfx;

    opens com.filesharingsystem2.filesharing to javafx.fxml;
    exports com.filesharingsystem2.filesharing;
}