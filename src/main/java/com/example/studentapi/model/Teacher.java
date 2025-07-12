package com.example.studentapi.model;

import java.util.HashMap;
import java.util.Map;

public class Teacher {
    String name;
    int teacherID;
    static int teacherIDcounter = 0;
    Map<String, Integer> grades = new HashMap<>();

    public Teacher(String name) {
        this.name = name;
        this.teacherID = generateID();
    }

    public static int generateID() {
        teacherIDcounter++;
        return teacherIDcounter;
    } 

    public String toString() {
        return "Name: " + this.name;
    }
 
}

