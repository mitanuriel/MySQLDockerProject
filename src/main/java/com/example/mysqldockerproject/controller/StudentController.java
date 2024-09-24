package com.example.mysqldockerproject.controller;

import com.example.mysqldockerproject.model.Student;
import com.example.mysqldockerproject.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    // POST request to add a new student
    @PostMapping("/add")
    public String addStudent(@RequestBody Student student) {
        studentRepository.save(student);
        return "Student added successfully!";
    }

    // GET request to fetch all students
    @GetMapping("/all")
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
}
