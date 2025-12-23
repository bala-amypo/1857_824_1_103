package com.example.demo.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/departments")
@Tag(name = "Departments Endpoints")
public class DepartmentController {

    @PostMapping
    public String createDepartment() {
        return "Department created";
    }

    @GetMapping
    public String getAllDepartments() {
        return "List of departments";
    }

    @GetMapping("/{id}")
    public String getDepartment(@PathVariable Long id) {
        return "Department with id " + id;
    }

    @DeleteMapping("/{id}")
    public String deleteDepartment(@PathVariable Long id) {
        return "Department deleted " + id;
    }
}
