package com.vijaypai.springboot.tutorial.service;

import com.vijaypai.springboot.tutorial.entity.Department;
import com.vijaypai.springboot.tutorial.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {
    @Autowired
    private DepartmentService departmentService;

    //searchServiceDepartmentByName method calls another layer i.e. DepartmentRepository.
    //Now while testing, we only test that layer and are not interested on other layers.
    //So we have to mock such cases and is done through mockito.

    @MockBean
    private DepartmentRepository departmentRepository;

    //created by right clicking on the actual class->Generate->Test->setup/@Before
    //The below method gets called for each of the test cases provided.
    //builder() is from @Builder Annotation
    @BeforeEach
    void setUp() {
        Department department =
                Department.builder()
                        .departmentId(1L)
                        .departmentName("IT")
                        .departmentAddress("Tesco, Bengaluru")
                        .departmentCode("T-01")
                        .build();

        Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("IT"))
                .thenReturn(department);
    }

    @Test
    @DisplayName("Valid Department Name")
    //@Disabled
    public void checkDepartmentNamePresentOrNot() {

        String departmentName = "IT";
        Department found = departmentService.searchServiceDepartmentByName(departmentName);

        assertEquals(departmentName, found.getDepartmentName());
    }
}