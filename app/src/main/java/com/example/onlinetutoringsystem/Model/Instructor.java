package com.example.onlinetutoringsystem.Model;

public class Instructor {

    private String instructorName;
    private String instructorMajor;

    public Instructor(String instructorName, String instructorMajor) {
        this.instructorName = instructorName;
        this.instructorMajor = instructorMajor;
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
