package com.example.onlinetutoringsystem.Data;

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

    @Query("SELECT * FROM Instructor Where instructorName LIKE :key or instructorMajor LIKE :key")
    List<Instructor> searchInstructor(String key);

    @Query("SELECT * FROM Instructor Where id = :id")
    Instructor getInstructor(int id);
    @Insert
    void insertInstructor(Instructor instructor);
    @Update
    void updateInstructor(Instructor instructor);
    @Delete
    void deleteInstructor(Instructor instructor);
    @Query("DELETE FROM Instructor")
    void deleteAll();


}
