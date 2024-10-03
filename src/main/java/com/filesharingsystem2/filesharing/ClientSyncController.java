package com.filesharingsystem2.filesharing;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class ClientSyncController {

    @FXML
    private TableView<FileData> fileTable;

    @FXML
    private TableColumn<FileData, String> fileNameColumn;

    @FXML
    private TableColumn<FileData, String> statusColumn;

    @FXML
    private TableColumn<FileData, ProgressBar> progressColumn;

    @FXML
    private Label statusLabel;

    @FXML
    protected void onSelectFilesClick() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Files for Synchronization");
        List<File> selectedFiles = fileChooser.showOpenMultipleDialog(null);

        if (selectedFiles != null) {
            for (File file : selectedFiles) {
                fileTable.getItems().add(new FileData(file.getName(), "Waiting", new ProgressBar(0)));
            }
        }
    }

    @FXML
    protected void onStartSyncClick() {
        statusLabel.setText("Status: Synchronizing...");
        for (FileData fileData : fileTable.getItems()) {
            fileData.getProgress().setProgress(1.0); // Simuleer synchronisatie
            fileData.setStatus("Completed");
        }
        statusLabel.setText("Status: Sync Completed.");
    }

    @FXML
    protected void onPauseSyncClick() {
        statusLabel.setText("Status: Synchronization Paused.");
    }

    // Deze methode zorgt voor de navigatie terug naar het Main Screen
    @FXML
    protected void goToMainScreen() {
        try {
            // Controleer of het FXML-bestand correct wordt geladen
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/filesharingsystem2/filesharing/hello-view.fxml"));
            Stage stage = (Stage) statusLabel.getScene().getWindow(); // Haal het huidige venster op
            Scene scene = new Scene(fxmlLoader.load(), 800, 600); // Stel de nieuwe scene in
            stage.setScene(scene); // Vervang de huidige scene met de Main Screen scene
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
