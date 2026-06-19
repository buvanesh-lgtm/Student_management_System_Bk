package com.example.Advanced_SMS.Entity;



import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;

@Entity
@Table(name = "student")


public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String department;
    @Column(nullable = false)
    private String yrs;
    @Email
    @NotBlank
    @Column(unique = true, nullable = false)
    private String email;
    @Pattern(regexp = "^[0-9]{10}$")
    @Column(unique = true, nullable = false)
    private String mobile;
    @Column(unique = true, nullable = false)
    private String registerNumber;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private String guardianName;
    @Column(nullable = false)
    private String bloodGroup;
    @Column(nullable = false)
    private LocalDate dateOfBirth;


    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    public void setYrs(String yrs) {
        this.yrs = yrs;
    }

    public String getYrs() {
        return yrs;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getRegisterNumber() {
        return registerNumber;
    }

    public void setRegisterNumber(String registerNumber) {
        this.registerNumber = registerNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGuardianName() {
        return guardianName;
    }

    public void setGuardianName(String guardianName) {
        this.guardianName = guardianName;
    }
}