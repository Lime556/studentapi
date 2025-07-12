package com.example.studentapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    private final List<Student> students = List.of(
        new Student(1, "Alice", 3.8, "CS"),
        new Student(2, "Bob", 3.4, "Math")
    );

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return students;
    }
}
