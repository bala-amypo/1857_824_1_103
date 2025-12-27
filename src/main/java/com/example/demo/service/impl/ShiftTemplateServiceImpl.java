package com.example.demo.service.impl;

import com.example.demo.model.ShiftTemplate;
import com.example.demo.repository.ShiftTemplateRepository;
import com.example.demo.service.ShiftTemplateService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShiftTemplateServiceImpl implements ShiftTemplateService {

    private final ShiftTemplateRepository shiftTemplateRepository;

    @Autowired
    public ShiftTemplateServiceImpl(ShiftTemplateRepository shiftTemplateRepository) {
        this.shiftTemplateRepository = shiftTemplateRepository;
    }

    @Override
    public ShiftTemplate createShiftTemplate(ShiftTemplate template) {
        return shiftTemplateRepository.save(template);
    }

    @Override
    public List<ShiftTemplate> getTemplatesByDepartment(Long departmentId) {
        return shiftTemplateRepository.findByDepartmentId(departmentId);
    }
}
