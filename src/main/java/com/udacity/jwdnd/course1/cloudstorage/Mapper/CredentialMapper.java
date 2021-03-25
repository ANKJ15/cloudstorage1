package com.udacity.jwdnd.course1.cloudstorage.Mapper;

import com.udacity.jwdnd.course1.cloudstorage.Model.Credential;
import com.udacity.jwdnd.course1.cloudstorage.Model.File;
import com.udacity.jwdnd.course1.cloudstorage.Model.Note;
import org.apache.ibatis.annotations.*;


import java.util.List;
@Mapper
public interface CredentialMapper {

    @Insert("INSERT INTO CREDENTIALS (url, username, key, password,userid) VALUES (#{credential.url}, #{credential.username}, #{credential.key}, #{credential.password}, #{credential.userid})")
    int insertCredential(Credential credential, int userid);

    @Select("SELECT * FROM CREDENTIALS WHERE credentialid = #{credentialid}")
    List<Credential> findByid(int userid);

    @Delete("DELETE FROM CREDENTIALS WHERE credentialid = #{credentialid}  ")
    int deleteCredential(int file);

    @Update("UPDATE CREDENTIALS SET CREDENTIALS = #{url}  , username = #{username}, key = #{key}, password = #{password}, userid = #{userid}  WHERE credentialid = #{credentialid} ")
    int updateCredential(Credential file);



}
