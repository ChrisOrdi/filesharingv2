package com.filesharingsystem2.filesharing;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import java.io.IOException;

public class HelloController {

    @FXML
    private Label statusLabel;

    @FXML
    protected void onStartServerClick() {
        statusLabel.setText("Status: Server starting...");

        // Start de server in een nieuwe thread
        new Thread(() -> {
            try {
                Server server = new Server();
                server.start(12345); // Start server op poort 12345
            } catch (IOException e) {
                e.printStackTrace();
                statusLabel.setText("Error: Could not start server.");
            }
        }).start();

        // Navigeren naar het server-dashboard (bijv. server-dashboard.fxml)
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("server-dashboard.fxml"));
            Scene serverScene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) statusLabel.getScene().getWindow();
            stage.setScene(serverScene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void onStartClientClick() {
        statusLabel.setText("Status: Client starting...");

        // Start de client in een nieuwe thread
        new Thread(() -> {
            try {
                Client client = new Client();
                client.start("localhost", 12345); // Verbind met de server op poort 12345
            } catch (IOException e) {
                e.printStackTrace();
                statusLabel.setText("Error: Could not start client.");
            }
        }).start();

        // Navigeren naar het client-bestandssynchronisatiescherm (bijv. client-file-sync.fxml)
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("client-file-sync.fxml"));
            Scene clientScene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) statusLabel.getScene().getWindow();
            stage.setScene(clientScene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void goToMainScreen() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/filesharingsystem2/filesharing/hello-view.fxml"));
            Stage stage = (Stage) statusLabel.getScene().getWindow(); // Haal het huidige venster op
            Scene scene = new Scene(fxmlLoader.load(), 800, 600); // Standaard grootte

            // Koppel het CSS-bestand opnieuw
            scene.getStylesheets().add(getClass().getResource("/com/filesharingsystem2/filesharing/styles.css").toExternalForm());

            stage.setScene(scene);
            stage.setFullScreen(true); // Zorg dat het scherm fullscreen blijft
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @FXML
    public void goToServerDashboard() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("server-dashboard.fxml"));
        Stage stage = (Stage) statusLabel.getScene().getWindow();
        stage.setScene(new Scene(fxmlLoader.load(), 800, 600));  // Vergroot het scherm
        stage.show();
    }

    @FXML
    public void goToClientSync() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("client-file-sync.fxml"));
        Stage stage = (Stage) statusLabel.getScene().getWindow();
        stage.setScene(new Scene(fxmlLoader.load(), 800, 600));  // Vergroot het scherm
        stage.show();
    }

}
