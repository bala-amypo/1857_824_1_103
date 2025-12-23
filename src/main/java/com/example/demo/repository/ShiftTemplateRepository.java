package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.Entityclass.ShiftTemplate;

public interface ShiftTemplateRepository extends JpaRepository<ShiftTemplate,Long>{
    
}