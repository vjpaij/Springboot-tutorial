package com.vijaypai.springboot.tutorial.service;

import com.vijaypai.springboot.tutorial.entity.Department;

import java.util.List;

public interface DepartmentService {
    public Department createServiceDepartment(Department department);

    public List<Department> fetchServiceDepartment();

    public Department searchServiceDepartment(Long departmentId);

    public void deleteServiceDepartment(Long departmentId);

    public Department updateServiceDepartment(Long departmentId, Department department);

    public Department searchServiceDepartmentByName(String departmentName);
}
