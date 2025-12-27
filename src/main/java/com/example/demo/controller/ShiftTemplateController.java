package com.example.demo.controller;

import com.example.demo.model.ShiftTemplate;
import com.example.demo.service.ShiftTemplateService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/templates")
public class ShiftTemplateController {

    private final ShiftTemplateService shiftTemplateService;

    public ShiftTemplateController(ShiftTemplateService shiftTemplateService) {
        this.shiftTemplateService = shiftTemplateService;
    }

    @PostMapping("/department/{departmentId}")
    public ShiftTemplate createTemplate(@RequestBody ShiftTemplate template) {
        return shiftTemplateService.createShiftTemplate(template);
    }

    @GetMapping("/department/{departmentId}")
    public List<ShiftTemplate> getTemplatesByDepartment(@PathVariable Long departmentId) {
        return shiftTemplateService.getTemplatesByDepartment(departmentId);
    }

    @GetMapping("/{id}")
    public ShiftTemplate getTemplate(@PathVariable Long id) {
        return null;
    }
}
