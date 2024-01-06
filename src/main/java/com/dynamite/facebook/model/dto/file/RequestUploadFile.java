package com.dynamite.facebook.model.dto.file;

public class RequestUploadFile {
    private String filePath;

    public RequestUploadFile() {
    }

    public RequestUploadFile(String filePath) {
        this.filePath = filePath;
    }

    public String getFilePath() {
        return filePath;
    }
}
