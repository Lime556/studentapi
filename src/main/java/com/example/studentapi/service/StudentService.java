package com.example.studentapi.service;

import com.example.studentapi.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    private final List<Student> students = new ArrayList<>(List.of(
        new Student(1, "Alice", 3.8, "CS"),
        new Student(2, "Bob", 3.4, "Math")
    ));

    public List<Student> getAllStudents() {
        return students;
    }

    public Student getStudentById(int id) {
        for (Student s : students) {
            if (s.getId() == id) return s;
        }
        return null;
    }

    public Student postStudent(Student student) {
        students.add(student);
        return student;
    }

    public Student deleteStudent(int id) {
        Student student = getStudentById(id);
        if (student != null) {
            students.remove(student);
            return student;
        }

        return null;
    }

    public Student updateStudent(int id, Student updatedData) {
        for (Student student: students) {
            if (student.getId() == id) {
                student.updateName(updatedData.getName());
                student.updateGPA(updatedData.getGPA());
                student.change_Major(updatedData.getMajor());
                return student;
            }
        }
        return null; 
    }
}
