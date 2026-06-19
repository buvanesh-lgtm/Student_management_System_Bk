package com.example.Advanced_SMS.Controller;

import com.example.Advanced_SMS.Entity.Marks;
import com.example.Advanced_SMS.Service.MarksService;
import com.example.Advanced_SMS.Service.studentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/marks")
@CrossOrigin("*")
public class MarksController {
    @Autowired
    private MarksService marksService;
    @Autowired
    private studentService studentService;

    @PostMapping("/create")
    public ResponseEntity<Marks> createMarks(@RequestBody Marks marks) {
        return ResponseEntity.ok(marksService.saveMarks(marks));
    }

    @GetMapping("/find")
    public List<Marks> getAllMarks() {
        return marksService.getAllMarks();
    }

    @GetMapping("/findbyid/{id}")
    public ResponseEntity<Marks> getById(@PathVariable int id) {
        return marksService.getMarksById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/findbystudent/{studentId}")
    public ResponseEntity<List<Marks>> getByStudent(@PathVariable int studentId) {
        return studentService.getStudentById(studentId)
                .map(student -> ResponseEntity.ok(marksService.getMarksByStudent(student)))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/findbysubject/{subject}")
    public List<Marks> getBySubject(@PathVariable String subject) {
        return marksService.getMarksBySubject(subject);
    }

    @GetMapping("/findbystudentandsubject/{studentId}/{subject}")
    public ResponseEntity<List<Marks>> getByStudentAndSubject(
            @PathVariable int studentId,
            @PathVariable String subject) {
        return studentService.getStudentById(studentId)
                .map(student -> ResponseEntity.ok(marksService.getMarksByStudentAndSubject(student, subject)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Marks> updateMarks(@PathVariable int id, @RequestBody Marks marks) {
        return marksService.getMarksById(id)
                .map(existing -> {
                    existing.setSubject(marks.getSubject());
                    existing.setMark(marks.getMark());
                    existing.setTotalMark(marks.getTotalMark());
                    existing.setExamDate(marks.getExamDate());
                    return ResponseEntity.ok(marksService.saveMarks(existing));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteMarks(@PathVariable int id) {
        marksService.deleteMarks(id);
        return ResponseEntity.noContent().build();
    }
}