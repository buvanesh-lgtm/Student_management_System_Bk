package com.example.Advanced_SMS.Controller;

import com.example.Advanced_SMS.Entity.Attendance;
import com.example.Advanced_SMS.Service.AttendanceService;
import com.example.Advanced_SMS.Service.studentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/attendance")
@CrossOrigin("*")
public class AttendanceController {
    @Autowired
    private AttendanceService attendanceService;
    @Autowired
    private studentService studentService;

    @PostMapping("/create")
    public ResponseEntity<Attendance> createAttendance(@RequestBody Attendance attendance) {
        return ResponseEntity.ok(attendanceService.saveAttendance(attendance));
    }

    @GetMapping("/find")
    public List<Attendance> getAllAttendance() {
        return attendanceService.getAllAttendance();
    }

    @GetMapping("/findbyid/{id}")
    public ResponseEntity<Attendance> getById(@PathVariable int id) {
        return attendanceService.getAttendanceById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/findbystudent/{studentId}")
    public ResponseEntity<List<Attendance>> getByStudent(@PathVariable int studentId) {
        return studentService.getStudentById(studentId)
                .map(student -> ResponseEntity.ok(attendanceService.getAttendanceByStudent(student)))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/findbydate/{date}")
    public List<Attendance> getByDate(@PathVariable String date) {
        return attendanceService.getAttendanceByDate(LocalDate.parse(date));
    }

    @GetMapping("/findbystatus/{status}")
    public List<Attendance> getByStatus(@PathVariable Attendance.AttendanceStatus status) {
        return attendanceService.getAttendanceByStatus(status);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Attendance> updateAttendance(@PathVariable int id,
                                                       @RequestBody Attendance attendance) {
        return attendanceService.getAttendanceById(id)
                .map(existing -> {
                    existing.setStudent(attendance.getStudent());
                    existing.setDate(attendance.getDate());
                    existing.setStatus(attendance.getStatus());
                    return ResponseEntity.ok(attendanceService.saveAttendance(existing));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteAttendance(@PathVariable int id) {
        attendanceService.deleteAttendance(id);
        return ResponseEntity.noContent().build();
    }
}