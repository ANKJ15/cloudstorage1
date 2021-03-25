package com.udacity.jwdnd.course1.cloudstorage.Controller;


import com.udacity.jwdnd.course1.cloudstorage.Mapper.UserMapper;
import com.udacity.jwdnd.course1.cloudstorage.services.CredentialService;
import com.udacity.jwdnd.course1.cloudstorage.services.EncryptionService;
import com.udacity.jwdnd.course1.cloudstorage.services.FilesService;
import com.udacity.jwdnd.course1.cloudstorage.services.NoteService;
import org.springframework.security.core.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private FilesService fileService;
    @Autowired
    private NoteService noteService;
    @Autowired
    private CredentialService credentialService;
    @Autowired
    private EncryptionService encryptionService;



    @GetMapping("/")
    public String showHome(Model model, Authentication authentication) throws Exception {
        Integer userId = userMapper.getUser(authentication.getName()).getUserId();
        model.addAttribute("files", fileService.getFiles(userId));
        model.addAttribute("fileService", fileService);
        model.addAttribute("notes", noteService.getNotes(userId));
        model.addAttribute("credentials", credentialService.getcre(userId));
        model.addAttribute("encryptionService", encryptionService);
        return "HOME";
    }

    @GetMapping("/result")
    public String showResult() {
        return "result";
    }

}
