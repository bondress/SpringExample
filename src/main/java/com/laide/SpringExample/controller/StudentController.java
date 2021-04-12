package com.laide.SpringExample.controller;

import com.laide.SpringExample.model.Student;
import com.laide.SpringExample.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @PostMapping
    public String create(@RequestBody Student student) {
        studentRepository.save(student);
        return "Student is created";
    }

    @GetMapping
    public List<Student> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        return students;
    }

}
