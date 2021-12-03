package com.example.onlinetutoringsystem.Model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity()
public class Instructor implements Serializable {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int id;
    private String instructorName;
    private String instructorMajor;
    private Double price;

    public Instructor( String instructorName, String instructorMajor, Double price) {
        this.instructorName = instructorName;
        this.instructorMajor = instructorMajor;
        this.price = price;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }

    public String getInstructorMajor() {
        return instructorMajor;
    }

    public void setInstructorMajor(String instructorMajor) {
        this.instructorMajor = instructorMajor;
    }

}
