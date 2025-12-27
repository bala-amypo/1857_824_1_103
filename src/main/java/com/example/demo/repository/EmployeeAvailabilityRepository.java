package com.example.demo.repository;

import com.example.demo.model.EmployeeAvailability;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeAvailabilityRepository extends JpaRepository<EmployeeAvailability, Long> {

    List<EmployeeAvailability> findByAvailableDate(LocalDate availableDate);

    List<EmployeeAvailability> findByEmployeeId(Long employeeId);
}
