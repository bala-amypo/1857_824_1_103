package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;

@Entity

public class Employee{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    private String email;
    private String role="STAFF";
    private String skills;
    private Long maxWeeklyHours;
    private LocalDateTime createdAt;
    
    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id=id;
    }

    public String getFullName(){
        return fullName;
    }
    public void setFullName(String fullName){
        this.fullName=fullName;
    }

    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email=email;
    }

    public String getRole(){
        return role;
    }
    public void setRole(String role){
        this.role=role;
    }

    public String getSkills(){
        return skills;
    }
    public void setRole(String skills){
        this.skills=skills;
    }

    public Long getMaxWeeklyHours(){
        return maxWeeklyHours;
    }
    public void setMaxWeeklyHours(Long maxWeeklyHours){
        if(maxWeeklyHours <= 0){
            throw new IllegalArgumentException("maxWeeklyHours must to be greater than 0");
        }
        this.maxWeeklyHours=maxWeeklyHours;
    }

    public LocalDateTime getCreatedAt(){
        return cretedAt;
    }
    public void setCreatedAt(LocalDateTime createdAt){
        this.createdAt=createdAt;
    }
}