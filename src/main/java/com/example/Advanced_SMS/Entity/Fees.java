package com.example.Advanced_SMS.Entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "fees")
public class Fees {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    private double amount;
    private LocalDate paidDate;
    private LocalDate dueDate;

    @Enumerated(EnumType.STRING)
    private FeeStatus status;

    public enum FeeStatus {
        PAID, PENDING, OVERDUE
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public Student getStudent() { return student; }
    public void setStudent(Student student) { this.student = student; }
    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }
    public LocalDate getPaidDate() { return paidDate; }
    public void setPaidDate(LocalDate paidDate) { this.paidDate = paidDate; }
    public LocalDate getDueDate() { return dueDate; }
    public void setDueDate(LocalDate dueDate) { this.dueDate = dueDate; }
    public FeeStatus getStatus() { return status; }
    public void setStatus(FeeStatus status) { this.status = status; }
}