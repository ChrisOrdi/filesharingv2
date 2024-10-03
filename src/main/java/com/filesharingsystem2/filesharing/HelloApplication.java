package com.filesharingsystem2.filesharing;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600); // Stel de grootte standaard in

        // Koppel het CSS-bestand
        scene.getStylesheets().add(getClass().getResource("/com/filesharingsystem2/filesharing/styles.css").toExternalForm());

        stage.setTitle("File Sharing Application Main Screen");
        stage.setScene(scene);
        stage.setFullScreen(true); // Maak het scherm fullscreen
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
