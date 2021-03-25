package com.udacity.jwdnd.course1.cloudstorage.Model;

public class File {
    private int  fileID;
    private String fileName;
    private String contentType;
    private String fileSize;
    private int userID;
    private byte[] fileData;


    public File(int fileID, String fileName, String contentType, String fileSize, int userID, byte[] fileData) {
        this.fileID = fileID;
        this.fileName = fileName;
        this.contentType = contentType;
        this.fileSize = fileSize;
        this.userID = userID;
        this.fileData = fileData;
    }

    public int getFileID() {
        return fileID;
    }

    public void setFileID(int fileID) {
        this.fileID = fileID;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public byte[] getFileData() {
        return fileData;
    }

    public void setFileData(byte[] fileData) {
        this.fileData = fileData;
    }
}
