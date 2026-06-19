package com.example.Advanced_SMS.Service;

import com.example.Advanced_SMS.Entity.Marks;
import com.example.Advanced_SMS.Entity.Student;
import com.example.Advanced_SMS.Repository.MarksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MarksService {
    @Autowired
    private MarksRepository repo;

    public Marks saveMarks(Marks marks) {
        return repo.save(marks);
    }

    public List<Marks> getAllMarks() {
        return repo.findAll();
    }

    public Optional<Marks> getMarksById(int id) {
        return repo.findById(id);
    }

    public List<Marks> getMarksByStudent(Student student) {
        return repo.findByStudent(student);
    }

    public List<Marks> getMarksBySubject(String subject) {
        return repo.findBySubject(subject);
    }

    public List<Marks> getMarksByStudentAndSubject(Student student, String subject) {
        return repo.findByStudentAndSubject(student, subject);
    }

    public void deleteMarks(int id) {
        repo.deleteById(id);
    }
}