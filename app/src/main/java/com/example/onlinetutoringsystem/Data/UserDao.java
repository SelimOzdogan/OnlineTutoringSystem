package com.example.onlinetutoringsystem.Data;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.onlinetutoringsystem.Model.User;
@Dao
public interface UserDao {

    @Query("SELECT * FROM User where email= :email and password= :password")
    User getUser(String email, String password);

    @Insert
    void insert(User user);

    @Update
    void update(User user);

    @Delete
    void delete(User user);
}
