package com.example.demo.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/schedules")
@Tag(name = "Shift Schedules Endpoints")
public class ScheduleController {

    @PostMapping("/generate/{date}")
    public String generateSchedule(@PathVariable LocalDate date) {
        return "Schedule generated for " + date;
    }

    @GetMapping("/date/{date}")
    public String getSchedule(@PathVariable LocalDate date) {
        return "Schedule for " + date;
    }
}
