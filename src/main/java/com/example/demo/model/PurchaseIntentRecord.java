package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false, unique = true)
    private String email;

    private String role = "STAFF";

    private String skills;

    @Column(nullable = false)
    private Integer maxWeeklyHours;

    private LocalDateTime createdAt;

    public Employee() {
    }

    public Employee(String fullName, String email, String role, String skills, Integer maxWeeklyHours) {
        this.fullName = fullName;
        this.email = email;
        if (role != null) {
            this.role = role;
        }
        this.skills = skills;
        this.maxWeeklyHours = maxWeeklyHours;
        this.createdAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }
    
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getRole() {
        return role;
    }
    
    public void setRole(String role) {
        if (role != null) {
            this.role = role;
        }
    }
    
    public String getSkills() {
        return skills;
    }

    public Set<String> getSkillsSet() {
        if (skills == null || skills.isEmpty()) {
            return new HashSet<>();
        }
        return new HashSet<>(Arrays.asList(skills.split(",")));
    }
    
    public void setSkills(String skills) {
        this.skills = skills;
    }
    
    public Integer getMaxWeeklyHours() {
        return maxWeeklyHours;
    }
    
    public void setMaxWeeklyHours(Integer maxWeeklyHours) {
        this.maxWeeklyHours = maxWeeklyHours;
    }
    
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
