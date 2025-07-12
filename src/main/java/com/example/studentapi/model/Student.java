package UniOrg.Student_Shit;

import java.util.HashMap;
import java.util.Map;

public class Student {
    String name;
    int StudentID;
    double GPA;
    String major;
    static int IDcounter = 0;
    Map<Course, Double> grades = new HashMap<>();

    public Student(String name, int GPA, String major) {
        this.name = name;
        this.GPA = GPA;
        this.major = major;
        this.StudentID = generateID();
    }

    public static int generateID() {
        IDcounter++;
        return IDcounter;
    } 

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
 
}
