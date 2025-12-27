package com.example.demo.repository;

import com.example.demo.model.ShiftTemplate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShiftTemplateRepository extends JpaRepository<ShiftTemplate, Long> {

    List<ShiftTemplate> findByDepartmentId(Long departmentId);
}
