package com.udacity.jwdnd.course1.cloudstorage.services;


import com.udacity.jwdnd.course1.cloudstorage.Mapper.FileMapper;
import com.udacity.jwdnd.course1.cloudstorage.Mapper.UserMapper;
import com.udacity.jwdnd.course1.cloudstorage.Model.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;
import java.util.List;


@Service
public class FilesService {


  @Autowired
  private FileMapper fileMapper;



    public FilesService(FileMapper fileMapper) {
        this.fileMapper = fileMapper;
    }


    public void addNewFile(MultipartFile file, int userid) {
        fileMapper.insert(file, userid);
    }

    public List<File> getFiles(Integer userid) {


        return fileMapper.findByUserId(userid);

    }

     public int updateFile(File x)
     {
         return fileMapper.updateFiles(x);
     }

    public String getFileData(int fileid) {
        File file = fileMapper.findByid(fileid);
        String base64 = Base64.getEncoder().encodeToString(file.getFileData());
        String dataURL = "data:" + file.getContentType() + ";base64," + base64;
        return dataURL;
    }
    public File findByid(int fileid) {
        return fileMapper.findByid(fileid);
    }
     public int deleteFile(int x)
     {
         return fileMapper.deleteFile(x);
     }

}
