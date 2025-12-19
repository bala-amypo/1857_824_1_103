package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.UniqueConstraint;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(uniqueConstraints = {
    @UniqueConstraint(
        name = "unique_employee_availability_date",
        columnNames = {"employee_id", "available_date"}
    )
})
public class EmployeeAvailability {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;
    
    @Column(name = "available_date", nullable = false)
    private LocalDate availableDate;
    
    @Column(nullable = false)
    private Boolean available = true;
    
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    
    @Column(name = "reason")
    private String reason;
    
    @Column(name = "preferred_shift")
    private String preferredShift;

    public EmployeeAvailability() {
    }
    
    public EmployeeAvailability(Employee employee, LocalDate availableDate, Boolean available) {
        this.employee = employee;
        this.availableDate = availableDate;
        this.available = available;
    }
    
    public EmployeeAvailability(Employee employee, LocalDate availableDate, Boolean available, 
        String reason, String preferredShift) {

        this.employee = employee;
        this.availableDate = availableDate;
        this.available = available;
        this.reason = reason;
        this.preferredShift = preferredShift;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Employee getEmployee() {
        return employee;
    }
    
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
    
    public LocalDate getAvailableDate() {
        return availableDate;
    }
    
    public void setAvailableDate(LocalDate availableDate) {
        this.availableDate = availableDate;
    }
    
    public Boolean getAvailable() {
        return available;
    }
    
    public void setAvailable(Boolean available) {
        this.available = available;
    }
    
    public Boolean isAvailable() {
        return available;
    }
    
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
    
    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
    
    public String getReason() {
        return reason;
    }
    
    public void setReason(String reason) {
        this.reason = reason;
    }
    
    public String getPreferredShift() {
        return preferredShift;
    }
    
    public void setPreferredShift(String preferredShift) {
        this.preferredShift = preferredShift;
    }

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
        validateData();
    }
    
    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
        validateData();
    }

    private void validateData() {
        if (availableDate == null) {
            throw new IllegalArgumentException("availableDate cannot be null");
        }
        
        if (availableDate.isBefore(LocalDate.now())) {

        }
        
        if (available == null) {
            available = true; 
        }
    }
    

    public boolean isFutureAvailability() {
        return availableDate.isAfter(LocalDate.now());
    }
    
    public boolean isToday() {
        return availableDate.isEqual(LocalDate.now());
    }
    
    public boolean isPastAvailability() {
        return availableDate.isBefore(LocalDate.now());
    }
    
    public java.time.DayOfWeek getDayOfWeek() {
        return availableDate.getDayOfWeek();
    }
    
    @Override
    public String toString() {
        return "EmployeeAvailability{" +
                "id=" + id +
                ", employee=" + (employee != null ? employee.getFullName() + " (ID: " + employee.getId() + ")" : "null") +
                ", availableDate=" + availableDate +
                ", available=" + available +
                ", reason='" + reason + '\'' +
                ", preferredShift='" + preferredShift + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        
        EmployeeAvailability that = (EmployeeAvailability) o;
        
        if (employee != null ? !employee.equals(that.employee) : that.employee != null) return false;
        return availableDate != null ? availableDate.equals(that.availableDate) : that.availableDate == null;
    }
    
    @Override
    public int hashCode() {
        int result = employee != null ? employee.hashCode() : 0;
        result = 31 * result + (availableDate != null ? availableDate.hashCode() : 0);
        return result;
    }
}