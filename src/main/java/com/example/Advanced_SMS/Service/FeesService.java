package com.example.Advanced_SMS.Service;

import com.example.Advanced_SMS.Entity.Fees;
import com.example.Advanced_SMS.Entity.Fees.FeeStatus;
import com.example.Advanced_SMS.Entity.Student;
import com.example.Advanced_SMS.Repository.FeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FeesService {
    @Autowired
    private FeesRepository repo;

    public Fees saveFees(Fees fees) {
        return repo.save(fees);
    }

    public List<Fees> getAllFees() {
        return repo.findAll();
    }

    public Optional<Fees> getFeesById(int id) {
        return repo.findById(id);
    }

    public List<Fees> getFeesByStudent(Student student) {
        return repo.findByStudent(student);
    }

    public List<Fees> getFeesByStatus(FeeStatus status) {
        return repo.findByStatus(status);
    }

    public List<Fees> getFeesByStudentAndStatus(Student student, FeeStatus status) {
        return repo.findByStudentAndStatus(student, status);
    }

    public void deleteFees(int id) {
        repo.deleteById(id);
    }
}