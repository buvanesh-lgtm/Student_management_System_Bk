package com.example.Advanced_SMS.Controller;

import com.example.Advanced_SMS.Entity.Student;
import com.example.Advanced_SMS.Service.studentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student/")
@CrossOrigin("*")

public class studentController {
    @Autowired
    private studentService service;
    @GetMapping("/find")
    public List<Student> getAllStudent(){
        return service.getAllStudents();
    }
    @GetMapping("/findbyid/{id}")
    public ResponseEntity<Student> studentGetbyId(@PathVariable int id) {
        return service.getStudentById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @PostMapping("/create")
    public Student createStudent( @Valid @RequestBody Student stu){
        return service.saveStudent(stu);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteStudentByID(@PathVariable int id){
        service.deleteStudentById(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable int id,@Valid @RequestBody Student stu){
        return service.getStudentById(id)
                .map(existing-> {
                    existing.setName(stu.getName());
                    existing.setDepartment((stu.getDepartment()));
                    existing.setYrs(stu.getYrs());
                    existing.setEmail(stu.getEmail());
                    existing.setMobile(stu.getMobile());
                    existing.setRegisterNumber(stu.getRegisterNumber());
                    existing.setDateOfBirth(stu.getDateOfBirth());
                    existing.setAddress(stu.getAddress());
                    existing.setGuardianName(stu.getGuardianName());
                    existing.setBloodGroup(stu.getBloodGroup());
                    return ResponseEntity.ok(service.saveStudent(existing));

                } )
                .orElse(ResponseEntity.notFound().build());
    }
    @GetMapping("/findbyname/{name}")
    public List<Student> findByName(@PathVariable String name) {
        return service.findByName(name);
    }
    @GetMapping("/findbydepartment/{department}")
    public List<Student> findByDepartment(@PathVariable String department) {
        return service.findByDepartment(department);
    }
    @GetMapping("/findByRegisterNumber/{registerNumber}")
    public ResponseEntity<Student> findByRegisterNumber(@PathVariable String registerNumber) {
        return service.findByRegisterNumber(registerNumber)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @GetMapping("/count")
    public ResponseEntity<Long> getCount() {
        return ResponseEntity.ok(service.getCount());
    }

}
