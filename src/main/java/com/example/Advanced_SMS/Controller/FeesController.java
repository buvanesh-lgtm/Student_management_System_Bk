package com.example.Advanced_SMS.Controller;

import com.example.Advanced_SMS.Entity.Fees;
import com.example.Advanced_SMS.Entity.Fees.FeeStatus;
import com.example.Advanced_SMS.Service.FeesService;
import com.example.Advanced_SMS.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fees")
@CrossOrigin("*")
public class FeesController {
    @Autowired
    private FeesService feesService;
    @Autowired
    private StudentService studentService;

    @PostMapping("/create")
    public ResponseEntity<Fees> createFees(@RequestBody Fees fees) {
        return ResponseEntity.ok(feesService.saveFees(fees));
    }

    @GetMapping("/find")
    public List<Fees> getAllFees() {
        return feesService.getAllFees();
    }

    @GetMapping("/findbyid/{id}")
    public ResponseEntity<Fees> getById(@PathVariable int id) {
        return feesService.getFeesById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/findbystudent/{studentId}")
    public ResponseEntity<List<Fees>> getByStudent(@PathVariable int studentId) {
        return studentService.getStudentById(studentId)
                .map(student -> ResponseEntity.ok(feesService.getFeesByStudent(student)))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/findbystatus/{status}")
    public List<Fees> getByStatus(@PathVariable FeeStatus status) {
        return feesService.getFeesByStatus(status);
    }

    @GetMapping("/findbystudentandstatus/{studentId}/{status}")
    public ResponseEntity<List<Fees>> getByStudentAndStatus(
            @PathVariable int studentId,
            @PathVariable FeeStatus status) {
        return studentService.getStudentById(studentId)
                .map(student -> ResponseEntity.ok(feesService.getFeesByStudentAndStatus(student, status)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Fees> updateFees(@PathVariable int id, @RequestBody Fees fees) {
        return feesService.getFeesById(id)
                .map(existing -> {
                    existing.setAmount(fees.getAmount());
                    existing.setPaidDate(fees.getPaidDate());
                    existing.setDueDate(fees.getDueDate());
                    existing.setStatus(fees.getStatus());
                    return ResponseEntity.ok(feesService.saveFees(existing));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteFees(@PathVariable int id) {
        feesService.deleteFees(id);
        return ResponseEntity.noContent().build();
    }
}