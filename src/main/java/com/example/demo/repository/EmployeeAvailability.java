package com.example.demo.repository;

import com.example.demo.model.EmployeeAvailability;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeAvailabilityRepository
        extends JpaRepository<EmployeeAvailability, Long> {
}
