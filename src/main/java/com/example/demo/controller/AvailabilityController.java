package com.example.demo.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/availability")
@Tag(name = "Employee Availability Endpoints")
public class AvailabilityController {

    @PostMapping("/{employeeId}")
    public String setAvailability(@PathVariable Long employeeId) {
        return "Availability set for employee " + employeeId;
    }

    @GetMapping("/employee/{employeeId}")
    public String getAvailabilityByEmployee(@PathVariable Long employeeId) {
        return "Availability for employee " + employeeId;
    }

    @GetMapping("/{availabilityId}")
    public String getAvailability(@PathVariable Long availabilityId) {
        return "Availability " + availabilityId;
    }

    // REQUIRED BY TEST SUITE
    @GetMapping("/date/{date}")
    public String getAvailabilityByDate(
            @PathVariable
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate date) {

        return "Availability on " + date;
    }
}
