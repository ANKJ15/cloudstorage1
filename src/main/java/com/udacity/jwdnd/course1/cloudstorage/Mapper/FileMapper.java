package com.udacity.jwdnd.course1.cloudstorage.Mapper;

import com.udacity.jwdnd.course1.cloudstorage.Model.File;
import org.apache.ibatis.annotations.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Mapper
public interface FileMapper {

    @Select("SELECT * FROM FILES WHERE userid = #{userid}")
    List<File> findByUserId(int userid);

    @Insert("INSERT INTO FILES (filename, filesize, contenttype, filedata, userid) VALUES (#{file.filename}, #{file.size}, #{file.contentType}, #{file.bytes}, #{userid})")
    int insert(MultipartFile file, int userid);

    @Select("SELECT * FROM FILES WHERE filename = #{filename} AND userid = #{userid}")
    File findBynameID(String filename, int userid);


    @Update("UPDATE FILES SET filename = #{filename}  , contenttype = #{contenttype}, filesize = #{filesize}, filedata = #{filedata}  WHERE fileid = #{fileid} ")
    int updateFiles(File file);

    @Delete("DELETE FROM FILES WHERE fileid = #{fileid}  ")
    int deleteFile(int file);

    @Select("SELECT * FROM FILES WHERE fileid = #{fileid}")
    File findByid(int fileid);

}

