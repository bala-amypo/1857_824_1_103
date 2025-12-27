package com.example.demo.service.impl;

import com.example.demo.model.EmployeeAvailability;
import com.example.demo.model.GeneratedShiftSchedule;
import com.example.demo.model.ShiftTemplate;
import com.example.demo.repository.EmployeeAvailabilityRepository;
import com.example.demo.repository.GeneratedShiftScheduleRepository;
import com.example.demo.repository.ShiftTemplateRepository;
import com.example.demo.service.ScheduleService;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    private final EmployeeAvailabilityRepository availabilityRepository;
    private final ShiftTemplateRepository shiftTemplateRepository;
    private final GeneratedShiftScheduleRepository scheduleRepository;

    @Autowired
    public ScheduleServiceImpl(
            EmployeeAvailabilityRepository availabilityRepository,
            ShiftTemplateRepository shiftTemplateRepository,
            GeneratedShiftScheduleRepository scheduleRepository) {
        this.availabilityRepository = availabilityRepository;
        this.shiftTemplateRepository = shiftTemplateRepository;
        this.scheduleRepository = scheduleRepository;
    }

    @Override
    public List<GeneratedShiftSchedule> generateSchedule(LocalDate date) {

        List<EmployeeAvailability> availabilities =
                availabilityRepository.findByAvailableDate(date);

        List<ShiftTemplate> templates = shiftTemplateRepository.findAll();
        List<GeneratedShiftSchedule> schedules = new ArrayList<>();

        for (ShiftTemplate template : templates) {
            for (EmployeeAvailability availability : availabilities) {
                if (Boolean.TRUE.equals(availability.getAvailable())) {
                    GeneratedShiftSchedule schedule =
                            new GeneratedShiftSchedule(
                                    date,
                                    template.getStartTime(),
                                    template.getEndTime(),
                                    template,
                                    template.getDepartment(),
                                    availability.getEmployee()
                            );
                    schedules.add(scheduleRepository.save(schedule));
                    break;
                }
            }
        }
        return schedules;
    }
}
