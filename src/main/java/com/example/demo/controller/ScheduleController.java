package com.example.demo.controller;

import com.example.demo.model.GeneratedShiftSchedule;
import com.example.demo.repository.GeneratedShiftScheduleRepository;
import com.example.demo.service.ScheduleService;
import java.time.LocalDate;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/schedules")
public class ScheduleController {

    private final ScheduleService scheduleService;
    private final GeneratedShiftScheduleRepository scheduleRepository;

    public ScheduleController(
            ScheduleService scheduleService,
            GeneratedShiftScheduleRepository scheduleRepository) {
        this.scheduleService = scheduleService;
        this.scheduleRepository = scheduleRepository;
    }

    @PostMapping("/generate/{date}")
    public List<GeneratedShiftSchedule> generateSchedule(@PathVariable String date) {
        return scheduleService.generateSchedule(LocalDate.parse(date));
    }

    @GetMapping("/date/{date}")
    public List<GeneratedShiftSchedule> getSchedule(@PathVariable String date) {
        return scheduleRepository.findByShiftDate(LocalDate.parse(date));
    }
}
