package com.udacity.jwdnd.course1.cloudstorage.Controller;

import com.udacity.jwdnd.course1.cloudstorage.Mapper.NoteMapper;
import com.udacity.jwdnd.course1.cloudstorage.Mapper.UserMapper;
import com.udacity.jwdnd.course1.cloudstorage.Model.File;
import com.udacity.jwdnd.course1.cloudstorage.Model.Note;
import com.udacity.jwdnd.course1.cloudstorage.Model.User;
import com.udacity.jwdnd.course1.cloudstorage.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.io.IOException;

@Controller
public class NotesController {


    @Autowired
    private NoteService noteService;

    @Autowired
    private NoteMapper notex;

    @Autowired
    private UserMapper userx;

    public NotesController(NoteMapper notex, UserMapper userx) {
        this.notex = notex;
        this.userx = userx;
    }

    @PostMapping("/note")
    public String addnote(Authentication authentication, Note notex)  {

        User user = userx.getUser(authentication.getName());
        if(notex.getNoteID() != null)
        {

            noteService.updateNote(notex);

        }
        else
        {
            notex.setUserid(user.getUserId());
            noteService.addNewNote(notex);
        }
        return "redirect:/result?success";
    }


    @GetMapping("/note/delete")
    public String delete(@RequestParam("id") int noteID) {
        if(noteID < 1) {
            return "redirect:/result?error";
        }

        noteService.deleteNote(noteID);

        return "redirect:/result?success";
    }
}
