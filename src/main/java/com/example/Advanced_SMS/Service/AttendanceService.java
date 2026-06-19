package com.example.Advanced_SMS.Service;

import com.example.Advanced_SMS.Entity.Attendance;
import com.example.Advanced_SMS.Entity.Student;
import com.example.Advanced_SMS.Repository.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class AttendanceService {
    @Autowired
    private AttendanceRepository repo;

    public Attendance saveAttendance(Attendance attendance) {
        return repo.save(attendance);
    }

    public List<Attendance> getAllAttendance() {
        return repo.findAll();
    }

    public Optional<Attendance> getAttendanceById(int id) {
        return repo.findById(id);
    }

    public List<Attendance> getAttendanceByStudent(Student student) {
        return repo.findByStudent(student);
    }

    public List<Attendance> getAttendanceByDate(LocalDate date) {
        return repo.findByDate(date);
    }

    public List<Attendance> getAttendanceByStatus(Attendance.AttendanceStatus status) {
        return repo.findByStatus(status);
    }

    public void deleteAttendance(int id) {
        repo.deleteById(id);
    }
}