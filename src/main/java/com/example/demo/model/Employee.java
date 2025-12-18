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
    private long id;
    private String fullname;
    private String email;
    private String role="STAFF";
    privare 
    
}