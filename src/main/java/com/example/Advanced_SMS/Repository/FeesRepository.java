package com.example.Advanced_SMS.Repository;

import com.example.Advanced_SMS.Entity.Fees;
import com.example.Advanced_SMS.Entity.Fees.FeeStatus;
import com.example.Advanced_SMS.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FeesRepository extends JpaRepository<Fees, Integer> {
    List<Fees> findByStudent(Student student);
    List<Fees> findByStatus(FeeStatus status);
    List<Fees> findByStudentAndStatus(Student student, FeeStatus status);
}