package com.udacity.jwdnd.course1.cloudstorage.Controller;


import com.udacity.jwdnd.course1.cloudstorage.Mapper.FileMapper;
import com.udacity.jwdnd.course1.cloudstorage.Mapper.UserMapper;
import com.udacity.jwdnd.course1.cloudstorage.Model.File;
import com.udacity.jwdnd.course1.cloudstorage.Model.User;
import com.udacity.jwdnd.course1.cloudstorage.services.FilesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller

public class FilesController {

@Autowired
private UserMapper userx;

    @Autowired
    private FilesService fileService;

    @Autowired
    private FileMapper filex;

    @PostMapping("/file")
    public String addFile(Authentication authentication, MultipartFile fileUpload) throws IOException {
        if(fileUpload.isEmpty()) {
            return "redirect:/result?error";
        }
        User user = userx.getUser(authentication.getName());

//        check if filename already exists
        File oldFile = filex.findBynameID(fileUpload.getOriginalFilename(), user.getUserId());
        if(oldFile != null) {
            return "redirect:/result?error";
        }
        fileService.addNewFile(fileUpload, user.getUserId());

        return "redirect:/result?success";
    }


    @GetMapping("/file/delete")
    public String delete(@RequestParam("id") int fileid, Authentication authentication) {
        if(fileid < 1) {
            return "redirect:/result?error";
        }

        User user = userx.getUser(authentication.getName());
        if(user.getUserId() != fileService.findByid(fileid).getUserID()) {
            return "redirect:/result?error";
        }

        fileService.deleteFile(fileid);

        return "redirect:/result?success";
    }

}
