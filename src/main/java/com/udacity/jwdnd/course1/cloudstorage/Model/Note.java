package com.udacity.jwdnd.course1.cloudstorage.Model;

public class Note {

    private Integer noteID;
    private String notetitle;
    private String notedescription;
    private Integer userid;


    public Note(Integer noteID, String notetitle, String notedescription, Integer userid) {
        this.noteID = noteID;
        this.notetitle = notetitle;
        this.notedescription = notedescription;
        this.userid = userid;
    }

    public Integer getNoteID() {
        return noteID;
    }

    public void setNoteID(Integer noteID) {
        this.noteID = noteID;
    }

    public String getNotetitle() {
        return notetitle;
    }

    public void setNotetitle(String notetitle) {
        this.notetitle = notetitle;
    }

    public String getNotedescription() {
        return notedescription;
    }

    public void setNotedescription(String notedescription) {
        this.notedescription = notedescription;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }
}
