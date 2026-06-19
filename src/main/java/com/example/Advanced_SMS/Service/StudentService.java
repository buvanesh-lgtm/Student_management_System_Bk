package com.example.Advanced_SMS.Service;

import com.example.Advanced_SMS.Entity.Student;
import com.example.Advanced_SMS.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repo;

    public List<Student> getAllStudents() {
        return repo.findAll();
    }

    public Optional<Student> getStudentById(int id) {
        return repo.findById(id);
    }

    public Student saveStudent(Student stu) {
        return repo.save(stu);
    }

    public void deleteStudentById(int id) {
        repo.deleteById(id);
    }

    public List<Student> findByName(String name) {
        return repo.findByNameContainingIgnoreCase(name);
    }

    public List<Student> findByDepartment(String department) {
        return repo.findByDepartmentContainingIgnoreCase(department);
    }

    public Optional<Student> findByRegisterNumber(String registerNumber) {
        return repo.findByRegisterNumber(registerNumber);
    }

    public long getCount() {
        return repo.count();
    }
}
