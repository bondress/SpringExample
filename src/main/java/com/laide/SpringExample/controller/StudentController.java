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

    @GetMapping("/findByFirstName/{firstName}")
    public Student getStudentByFirstName(@PathVariable String firstName){
        return studentRepository.findByFirstname(firstName);
    }

    @GetMapping("/findById/{id}")
    public Student getStudentById(@PathVariable Integer id){
        return studentRepository.findById(id);
    }

    @DeleteMapping("/deleteByFirstName/{firstName}")
    public String deleteStudentByFirstName(@PathVariable String firstName){
        Student student = studentRepository.findByFirstname(firstName);
        studentRepository.delete(student);
        return "Student is deleted";
    }

    @PutMapping("/updateById/{id}")
    public Student updateStudentById(@PathVariable Integer id, @RequestBody Student studentDetails){
        Student student = studentRepository.findById(id);
        student.setFirstname(studentDetails.getFirstname());
        student.setLastname(studentDetails.getLastname());
        final Student updatedStudent = studentRepository.save(student);
        return updatedStudent;
    }
}
