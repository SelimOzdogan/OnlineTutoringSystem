package com.example.onlinetutoringsystem.Data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.onlinetutoringsystem.Model.Instructor;

import java.util.List;

@Dao
public interface InstructorDao {
    @Query("SELECT * FROM Instructor")
    List<Instructor> getInstructorList();
    @Insert
    void insertInstructor(Instructor instructor);
    @Update
    void updateInstructor(Instructor instructor);
    @Delete
    void deleteInstructor(Instructor instructor);
    @Query("DELETE FROM Instructor")
    void deleteAll();

}
