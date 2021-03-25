package com.udacity.jwdnd.course1.cloudstorage.Controller;

import com.udacity.jwdnd.course1.cloudstorage.Mapper.CredentialMapper;
import com.udacity.jwdnd.course1.cloudstorage.Mapper.UserMapper;
import com.udacity.jwdnd.course1.cloudstorage.Model.Credential;
import com.udacity.jwdnd.course1.cloudstorage.Model.User;
import com.udacity.jwdnd.course1.cloudstorage.services.CredentialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CredentialController {


    @Autowired
    private CredentialService credentialService;

    @Autowired
    private CredentialMapper crex;

    @Autowired
    private UserMapper userx;

    public CredentialController(CredentialService credentialService, CredentialMapper crex, UserMapper userx) {
        this.credentialService = credentialService;
        this.crex = crex;
        this.userx = userx;
    }



    @PostMapping("/credential")
    public String addcredential(Authentication authentication, Credential crex)  {

        User user = userx.getUser(authentication.getName());
        if(crex.getCredentialid() != null)
        {

            credentialService.updateNote(crex);

        }
        else
        {
            credentialService.addNewcredential(crex,user.getUserId());
        }
        return "redirect:/result?success";
    }


    @GetMapping("/credential/delete")
    public String delete(@RequestParam("id") int creID) {
        if(creID < 1) {
            return "redirect:/result?error";
        }

        credentialService.deleteNote(creID);

        return "redirect:/result?success";
    }



}
