package com.vijaypai.springboot.tutorial.repository;

import com.vijaypai.springboot.tutorial.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Jpa repository gives lot of methods for interacting our entity with database.
//Pass entity and datatype of the ID field.
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    public Department findByDepartmentName(String departmentName);

    //there are keywords in JPA Repository which performs the keyword it translates to. For eg: below
    //query by just saying Ignore case, it will ignore the input whether its capital or small. But note
    //that method name should have the exact variable name (eg:DepartmentName). There are more such
    //keywords in the below link
    //https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods
    //For any complex logic, we can pass SQL query using @Query.
    //https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.at-query
    public Department findByDepartmentNameIgnoreCase(String departmentName);
}

