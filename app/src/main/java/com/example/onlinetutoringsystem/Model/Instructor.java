package com.example.onlinetutoringsystem.Model;

import java.io.Serializable;

public class Instructor implements Serializable {

    private String instructorId;
    private String instructorName;
    private String instructorMajor;
    private Double price;

    public Instructor(String instructorId, String instructorName, String instructorMajor, Double price) {
        this.instructorId = instructorId;
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

    public String getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(String instructorId) {
        this.instructorId = instructorId;
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
