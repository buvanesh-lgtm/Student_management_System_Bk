package com.example.Advanced_SMS.Repository;

import com.example.Advanced_SMS.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findByNameContainingIgnoreCase(String name);
    List<Student> findByDepartmentContainingIgnoreCase(String department);
    Optional<Student> findByRegisterNumber(String registerNumber);

}
