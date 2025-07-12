package com.example.studentapi.model;

import java.util.HashMap;
import java.util.Map;

public class Student {
    private String name;
    private int StudentID;
    private double GPA;
    private String major;
    private static int IDcounter = 0;
    Map<Course, Double> grades = new HashMap<>();

    public Student(int StudentId, String name, double GPA, String major) {
        this.name = name;
        this.GPA = GPA;
        this.major = major;
        this.StudentID = generateID(); //use generateID() for automated ID generation
    }

    public static int generateID() {
        IDcounter++;
        return IDcounter;
    } 

    @Override
    public String toString() {
        return "Name: " + this.name + ", Major: " + this.major + ", GPA: " + this.GPA;
    }

    public void updateGPA(double new_GPA) {
        this.GPA = new_GPA;
    }

    public void change_Major(String new_Major) {
        this.major = new_Major;
    }

    public void enroll(Course c, double grade) {
        if (c.current_student_count > c.student_limit) {
            throw new IllegalStateException("Course is already at Capacity!");
        } else if (c.gradebook.containsKey(this)) {
            throw new IllegalStateException("You are already enrolled!");
        } else {
            c.gradebook.put(this, grade);
            grades.put(c, grade);
        }
    }

    public void deroll(Course c) {
        if (!c.gradebook.containsKey(this)) {
            throw new IllegalStateException("You are not enrolled!");
        } else {
            c.gradebook.remove(this);
            grades.remove(c);
        }
    }

    public Map<Course, Double> getGrades() {
        return grades;
    }
    
    public int getId() {
        return StudentID;
    }
    
    public String getName() {
        return name;
    }
    
    public double getGPA() {
        return GPA;
    }
    
    public String getMajor() {
        return major;
    }

    public void updateName(String name) {
        this.name = name;
    }
    
}
