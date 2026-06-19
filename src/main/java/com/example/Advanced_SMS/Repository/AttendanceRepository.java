package com.example.Advanced_SMS.Repository;

import com.example.Advanced_SMS.Entity.Attendance;
import com.example.Advanced_SMS.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface AttendanceRepository extends JpaRepository<Attendance, Integer> {
    List<Attendance> findByStudent(Student student);
    List<Attendance> findByDate(LocalDate date);
    List<Attendance> findByStudentAndDate(Student student, LocalDate date);
    List<Attendance> findByStatus(Attendance.AttendanceStatus status);
}