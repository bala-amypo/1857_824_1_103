package com.example.demo.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/templates")
@Tag(name = "Shift Templates Endpoints")
public class ShiftTemplateController {

    @PostMapping("/department/{departmentId}")
    public String createTemplate(@PathVariable Long departmentId) {
        return "Template created for department " + departmentId;
    }

    @GetMapping("/department/{departmentId}")
    public String getTemplates(@PathVariable Long departmentId) {
        return "Templates for department " + departmentId;
    }

    @GetMapping("/{id}")
    public String getTemplate(@PathVariable Long id) {
        return "Template " + id;
    }
}
