package com.vijaypai.springboot.tutorial.repository;

import com.vijaypai.springboot.tutorial.entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class DepartmentRepositoryTest {
    @Autowired
    private DepartmentRepository departmentRepository;

    //Testing database need Entity Manager to persist data into database which is present in
    //JPA package
    @Autowired
    private TestEntityManager testEntityManager;

    @BeforeEach
    void setUp() {
        Department department =
                Department.builder()
                        .departmentName("HR")
                        //.departmentId(2L)
                        .departmentAddress("Tesco Bengaluru")
                        .departmentCode("T-02")
                        .build();

        testEntityManager.persist(department);
    }

    @Test
    @DisplayName("Department For Id")
    public void returnDepartmentForIdProvided(){

        Department department = departmentRepository.findById(1L).get();
        assertEquals(department.getDepartmentName(),"HR");

    }
}