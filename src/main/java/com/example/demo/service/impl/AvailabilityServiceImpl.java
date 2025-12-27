package com.example.demo.service.impl;

import com.example.demo.model.EmployeeAvailability;
import com.example.demo.repository.EmployeeAvailabilityRepository;
import com.example.demo.service.AvailabilityService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AvailabilityServiceImpl implements AvailabilityService {

    private final EmployeeAvailabilityRepository availabilityRepository;

    @Autowired
    public AvailabilityServiceImpl(EmployeeAvailabilityRepository availabilityRepository) {
        this.availabilityRepository = availabilityRepository;
    }

    @Override
    public EmployeeAvailability markAvailability(EmployeeAvailability availability) {
        return availabilityRepository.save(availability);
    }

    @Override
    public List<EmployeeAvailability> getAvailabilityByEmployee(Long employeeId) {
        return availabilityRepository.findByEmployeeId(employeeId);
    }
}
