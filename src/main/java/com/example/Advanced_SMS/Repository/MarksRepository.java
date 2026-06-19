package com.example.Advanced_SMS.Repository;

import com.example.Advanced_SMS.Entity.Marks;
import com.example.Advanced_SMS.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MarksRepository extends JpaRepository<Marks, Integer> {
    List<Marks> findByStudent(Student student);
    List<Marks> findBySubject(String subject);
    List<Marks> findByStudentAndSubject(Student student, String subject);
}