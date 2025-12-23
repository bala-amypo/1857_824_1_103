package com.example.demo.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/schedules")
@Tag(name = "Shift Schedules Endpoints")
public class ScheduleController {

    @PostMapping("/generate/{date}")
    public String generateSchedule(
            @PathVariable
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate date) {

        return "Schedule generated for " + date;
    }

    @GetMapping("/date/{date}")
    public String getSchedule(
            @PathVariable
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate date) {

        return "Schedule for " + date;
    }
}
