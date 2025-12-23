package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.Entityclass.EmployeeAvailability;

public interface AvailabilityRepository extends JpaRepository<User,Long>{
    
}