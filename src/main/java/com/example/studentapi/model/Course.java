package com.example.studentapi.model;

import java.util.HashMap;
import java.util.Map;

public class Course {
    String name;
    int student_limit;
    int current_student_count = 0;
    Teacher teacher;
    Map<Student, Double> gradebook = new HashMap<>();

    public Course(String name, int student_limit, Teacher teacher) {
        this.student_limit = student_limit;
        this.name = name;
        this.teacher = teacher;
    }

    public void enroll(Student s, double grade) {
        if (current_student_count > student_limit) {
            throw new IllegalStateException("Course is already at Capacity!");
        } else if (gradebook.containsKey(s)) {
            throw new IllegalStateException("Student is already enrolled!");
        } else {
            gradebook.put(s, grade);
            s.grades.put(this, grade);
        }
    }

    public void changeGrade(Student s, double grade) {
        if (!gradebook.containsKey(s)) {
            throw new IllegalStateException("Student is not enrolled!");
        } else {
            gradebook.put(s, grade);
        }
    }

    public void deroll(Student s) {
        if (!gradebook.containsKey(s)) {
            throw new IllegalStateException("Student is not enrolled!");
        } else {
            gradebook.remove(s);
            s.grades.remove(this);
        }
    }

    public void changeTeacher(Teacher t) {
        this.teacher = t;
    }

    public Map<Student, Double> getGrades() {
        return this.gradebook;
    }
    
}
