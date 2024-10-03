package com.filesharingsystem2.filesharing;

import javafx.scene.control.ProgressBar;

public class FileData {
    private String fileName;
    private String status;
    private ProgressBar progress;

    public FileData(String fileName, String status, ProgressBar progress) {
        this.fileName = fileName;
        this.status = status;
        this.progress = progress;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ProgressBar getProgress() {
        return progress;
    }

    public void setProgress(ProgressBar progress) {
        this.progress = progress;
    }
}
