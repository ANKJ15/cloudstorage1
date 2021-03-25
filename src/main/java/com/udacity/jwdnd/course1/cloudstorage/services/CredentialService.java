package com.udacity.jwdnd.course1.cloudstorage.services;

import com.udacity.jwdnd.course1.cloudstorage.Mapper.CredentialMapper;
import com.udacity.jwdnd.course1.cloudstorage.Model.Credential;
import com.udacity.jwdnd.course1.cloudstorage.Model.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Base64;
import java.util.List;

@Service
public class CredentialService {


    @Autowired
    private CredentialMapper credentialMapper;
    @Autowired
    private EncryptionService encryptionService;

    public CredentialService(CredentialMapper credentialMapper) {
        this.credentialMapper = credentialMapper;
    }
   private Credential passwordEncription(Credential x)
{
    SecureRandom random = new SecureRandom();
    byte[] key = new byte[16];
    random.nextBytes(key);
    String encodedKey = Base64.getEncoder().encodeToString(key);
    x.setKey(encodedKey);
    x.setPassword(encryptionService.encryptValue(x.getPassword(), encodedKey));
    return x;

}
    public void addNewcredential(Credential credential,int userid) {

        credentialMapper.insertCredential(passwordEncription(credential),userid);

    }

    public void updateNote(Credential credential) {

        credentialMapper.updateCredential(passwordEncription(credential));

    }
    public void deleteNote(int credential) {

        credentialMapper.deleteCredential(credential);

    }


    public List<Credential> getcre(Integer userid) {


        return credentialMapper.findByid(userid);

    }

}
