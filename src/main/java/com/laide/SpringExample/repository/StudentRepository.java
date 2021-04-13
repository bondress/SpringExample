package com.laide.SpringExample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.laide.SpringExample.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {
    Student findByFirstname(String firstName);
}