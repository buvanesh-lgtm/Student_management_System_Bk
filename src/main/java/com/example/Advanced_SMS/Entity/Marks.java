package com.example.Advanced_SMS.Entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "marks")
public class Marks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    private String subject;
    private double mark;
    private double totalMark;
    private LocalDate examDate;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public Student getStudent() { return student; }
    public void setStudent(Student student) { this.student = student; }
    public String getSubject() { return subject; }
    public void setSubject(String subject) { this.subject = subject; }
    public double getMark() { return mark; }
    public void setMark(double mark) { this.mark = mark; }
    public double getTotalMark() { return totalMark; }
    public void setTotalMark(double totalMark) { this.totalMark = totalMark; }
    public LocalDate getExamDate() { return examDate; }
    public void setExamDate(LocalDate examDate) { this.examDate = examDate; }
}