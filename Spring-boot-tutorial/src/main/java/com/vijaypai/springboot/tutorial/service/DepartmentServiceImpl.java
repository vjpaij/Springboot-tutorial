package com.vijaypai.springboot.tutorial.service;

import com.vijaypai.springboot.tutorial.entity.Department;
import com.vijaypai.springboot.tutorial.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService{


    @Autowired
    private DepartmentRepository departmentRepository;
    @Override
    public Department createServiceDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchServiceDepartment() {
        return departmentRepository.findAll();
    }

    @Override
    public Department searchServiceDepartment(Long departmentId) {
        return departmentRepository.findById(departmentId).get();
    }

    @Override
    public void deleteServiceDepartment(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    @Override
    public Department updateServiceDepartment(Long departmentId, Department department) {
        Department updDep = departmentRepository.findById(departmentId).get();

        if (department.getDepartmentName() != null && department.getDepartmentName() != "") {
            updDep.setDepartmentName(department.getDepartmentName());
        }

        if (department.getDepartmentAddress() != null && department.getDepartmentAddress() != "") {
            updDep.setDepartmentAddress(department.getDepartmentAddress());
        }

        if (department.getDepartmentCode() != null && department.getDepartmentCode() != "") {
            updDep.setDepartmentCode(department.getDepartmentCode());
        }

        return departmentRepository.save(updDep);
    }

    @Override
    public Department searchServiceDepartmentByName(String departmentName) {
        return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
    }
}
