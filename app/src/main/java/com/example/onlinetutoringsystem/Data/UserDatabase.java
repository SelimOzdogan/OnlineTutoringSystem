package com.example.onlinetutoringsystem.Data;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.onlinetutoringsystem.Model.Transaction;
import com.example.onlinetutoringsystem.Model.User;

@Database(entities = {User.class, Transaction.class}, version = 1, exportSchema = false)
public abstract class UserDatabase extends RoomDatabase {
    public abstract UserDao getUserDao();
    public abstract TransactionDao gettransactionDao();

}
