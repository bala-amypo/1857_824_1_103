package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "generated_shift_schedules")
public class GeneratedShiftSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate shiftDate;

    private LocalTime startTime;

    private LocalTime endTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shift_template_id")
    private ShiftTemplate shiftTemplate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    public GeneratedShiftSchedule() {
    }

    public GeneratedShiftSchedule(LocalDate shiftDate, LocalTime startTime, LocalTime endTime,
                                  ShiftTemplate shiftTemplate, Department department, Employee employee) {
        this.shiftDate = shiftDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.shiftTemplate = shiftTemplate;
        this.department = department;
        this.employee = employee;
    }

    public Long getId() {
        return id;
    }
    
    public LocalDate getShiftDate() {
        return shiftDate;
    }
    
    public void setShiftDate(LocalDate shiftDate) {
        this.shiftDate = shiftDate;
    }
    
    public LocalTime getStartTime() {
        return startTime;
    }
    
    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }
    
    public LocalTime getEndTime() {
        return endTime;
    }
    
    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }
    
    public ShiftTemplate getShiftTemplate() {
        return shiftTemplate;
    }
    
    public Department getDepartment() {
        return department;
    }
    
    public Employee getEmployee() {
        return employee;
    }
}
