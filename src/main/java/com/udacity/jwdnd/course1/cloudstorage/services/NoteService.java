package com.udacity.jwdnd.course1.cloudstorage.services;

import com.udacity.jwdnd.course1.cloudstorage.Mapper.NoteMapper;
import com.udacity.jwdnd.course1.cloudstorage.Model.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {

    @Autowired
    private NoteMapper noteMapper;

    public NoteService(NoteMapper noteMapper) {
        this.noteMapper = noteMapper;
    }


    public void addNewNote(Note note) {

        noteMapper.insert(note);

    }

    public void updateNote(Note note) {

        noteMapper.updateNotes(note);

    }
    public void deleteNote(int note) {

        noteMapper.deleteNotes(note);

    }

    public List<Note> getNotes(Integer userid) {


        return noteMapper.findByid(userid);
    }


}
