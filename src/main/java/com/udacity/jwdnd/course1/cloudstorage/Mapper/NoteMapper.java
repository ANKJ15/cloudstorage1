package com.udacity.jwdnd.course1.cloudstorage.Mapper;

import com.udacity.jwdnd.course1.cloudstorage.Model.Note;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface NoteMapper {
    @Insert("INSERT INTO NOTES (notetitle, notedescription, userid) VALUES (#{notetitle}, #{notedescription}, #{userid})")
    int insert(Note userid);

    @Update("UPDATE NOTES SET notetitle = #{notetitle}  , notedescription = #{notedescription}  WHERE noteid = #{noteid} ")
    int updateNotes(Note note);

    @Delete("DELETE FROM NOTES WHERE noteid = #{noteid}  ")
    int deleteNotes(int note);

    @Select("SELECT * FROM NOTES WHERE userid = #{userid}")
    List<Note> findByid(int userid);

}


