package com.example.onlinetutoringsystem.Data;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.onlinetutoringsystem.Model.Transaction;

import java.util.List;

@Dao
public interface TransactionDao {
    @Query("SELECT * FROM 'Transaction' WHERE userid = :UserId")
    List<Transaction> getTransactions(String UserId);

    @Insert()
    void insert(Transaction transaction);
}
