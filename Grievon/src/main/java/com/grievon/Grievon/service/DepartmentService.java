package com.grievon.Grievon.service;

import com.grievon.Grievon.model.Department;

import java.util.List;

public interface DepartmentService {
    Department createDepartment(Department department);
    List<Department> getAllDepartments();
    Department getDepartmentByName(String name);
}
