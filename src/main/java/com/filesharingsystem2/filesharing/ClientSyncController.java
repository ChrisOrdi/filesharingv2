package com.filesharingsystem2.filesharing;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.stage.FileChooser;
import javafx.scene.control.ProgressBar;

import java.io.File;
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
        // Gebruik een FileChooser om bestanden te selecteren
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Files for Synchronization");
        List<File> selectedFiles = fileChooser.showOpenMultipleDialog(null);

        if (selectedFiles != null) {
            // Voeg de geselecteerde bestanden toe aan de TableView (fileTable)
            for (File file : selectedFiles) {
                fileTable.getItems().add(new FileData(file.getName(), "Waiting", new ProgressBar(0)));
            }
        }
    }

    @FXML
    protected void onStartSyncClick() {
        // Start synchronisatie logica
        statusLabel.setText("Status: Synchronizing...");
        // Update de voortgangsbalken in de fileTable
        for (FileData fileData : fileTable.getItems()) {
            // Simuleer synchronisatie (in een echte applicatie wordt dit vervangen door echte synchronisatielogica)
            fileData.getProgress().setProgress(1.0); // Synchronisatie voltooid
            fileData.setStatus("Completed");
        }
        statusLabel.setText("Status: Sync Completed.");
    }

    @FXML
    protected void onPauseSyncClick() {
        // Logica voor het pauzeren van de synchronisatie
        statusLabel.setText("Status: Synchronization Paused.");
    }

    @FXML
    protected void goToMainScreen() {
        // Navigatie terug naar het hoofdscherm
    }
}
