package com.example.demo.service;

import com.example.demo.model.EmployeeAvailability;
import java.util.List;

public interface AvailabilityService {

    EmployeeAvailability markAvailability(EmployeeAvailability availability);

    List<EmployeeAvailability> getAvailabilityByEmployee(Long employeeId);
}
