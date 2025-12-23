package com.example.demo.service.impl;

import com.example.demo.model.EmployeeAvailability;
import com.example.demo.repository.EmployeeAvailabilityRepository;
import com.example.demo.service.AvailabilityService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AvailabilityServiceImpl implements AvailabilityService {

    private final EmployeeAvailabilityRepository availabilityRepository;

    public AvailabilityServiceImpl(EmployeeAvailabilityRepository availabilityRepository) {
        this.availabilityRepository = availabilityRepository;
    }

    @Override
    public EmployeeAvailability create(EmployeeAvailability availability) {
        return availabilityRepository.save(availability);
    }

    @Override
    public EmployeeAvailability update(Long id, EmployeeAvailability availability) {
        EmployeeAvailability existing = availabilityRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Availability not found"));
        existing.setEmployeeId(availability.getEmployeeId());
        existing.setAvailabilityId(availability.getAvailabilityId());
        return availabilityRepository.save(existing);
    }

    @Override
    public void delete(Long id) {
        availabilityRepository.deleteById(id);
    }

    @Override
    public List<EmployeeAvailability> getByDate(LocalDate date) {
        return availabilityRepository.findAll(); // filter later
    }
}
