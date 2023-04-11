package com.vijaypai.springboot.tutorial.controller;

import com.vijaypai.springboot.tutorial.entity.Department;
import com.vijaypai.springboot.tutorial.service.DepartmentService;
import com.vijaypai.springboot.tutorial.service.DepartmentServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    //to create a department
    @PostMapping("/departments")
    public Department createDepartment(@Valid @RequestBody Department department) {

        //to pass department data, we need to call service layer.
        //Ideally we would have created an object as below but Spring would have this object already.
        //DepartmentService service = new DepartmentServiceImpl();
        //Hence, we will create variable with the object type and as we are asking Spring for it,
        //we give @Autowire

        return departmentService.createServiceDepartment(department);

    }

    @GetMapping("/departments")
    public List<Department> fetchDepartment() {
        LOGGER.info("Inside Fetch Department");
        return departmentService.fetchServiceDepartment();
    }

    @GetMapping("/departments/{id}")
    public Department searchDepartment(@PathVariable("id") Long departmentId) {
        LOGGER.info("Inside Search Department");
        return departmentService.searchServiceDepartment(departmentId);
    }

    @DeleteMapping("/departments/{id}")
    public String deleteDepartment(@PathVariable("id") Long departmentId) {
        departmentService.deleteServiceDepartment(departmentId);
        return ("Department id " + departmentId + " successfully deleted");
    }

    @PutMapping("/departments/{id}")
    public Department updateDepartment(@Valid @PathVariable("id") Long departmentId,
                                       @RequestBody Department department) {
        return departmentService.updateServiceDepartment(departmentId, department);

    }

    //there are methods in JPA repository to pick data from primary key but not other fields
    //such we need to create our own method.

    @GetMapping("/departments/name/{name}")
    public Department searchDepartmentByName(@PathVariable("name") String departmentName) {
        return departmentService.searchServiceDepartmentByName(departmentName);
    }
}
