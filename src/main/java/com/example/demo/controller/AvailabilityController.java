package com.example.demo.controller;

import com.example.demo.model.EmployeeAvailability;
import com.example.demo.repository.EmployeeAvailabilityRepository;
import com.example.demo.service.AvailabilityService;
import java.time.LocalDate;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/availability")
public class AvailabilityController {

    private final AvailabilityService availabilityService;
    private final EmployeeAvailabilityRepository availabilityRepository;

    public AvailabilityController(
            AvailabilityService availabilityService,
            EmployeeAvailabilityRepository availabilityRepository) {
        this.availabilityService = availabilityService;
        this.availabilityRepository = availabilityRepository;
    }

    @PostMapping("/{employeeId}")
    public EmployeeAvailability setAvailability(@RequestBody EmployeeAvailability availability) {
        return availabilityService.markAvailability(availability);
    }

    @GetMapping("/employee/{employeeId}")
    public List<EmployeeAvailability> getByEmployee(@PathVariable Long employeeId) {
        return availabilityService.getAvailabilityByEmployee(employeeId);
    }

    @GetMapping("/{availabilityId}")
    public EmployeeAvailability getAvailability(@PathVariable Long availabilityId) {
        return availabilityRepository.findById(availabilityId).orElse(null);
    }

    @GetMapping("/date/{date}")
    public List<EmployeeAvailability> getByDate(@PathVariable String date) {
        return availabilityRepository.findByAvailableDate(LocalDate.parse(date));
    }
}
