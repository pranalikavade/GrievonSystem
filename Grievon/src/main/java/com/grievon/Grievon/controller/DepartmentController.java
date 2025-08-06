package com.grievon.Grievon.controller;

import com.grievon.Grievon.model.Department;
import com.grievon.Grievon.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
@CrossOrigin
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping
    public Department createDepartment(@RequestBody Department department) {
        return departmentService.createDepartment(department);
    }

    @GetMapping
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @GetMapping("/name/{name}")
    public Department getDepartmentByName(@PathVariable String name) {
        return departmentService.getDepartmentByName(name);
    }
}
