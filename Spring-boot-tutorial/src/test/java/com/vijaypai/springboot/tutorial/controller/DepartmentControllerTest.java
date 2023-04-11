package com.vijaypai.springboot.tutorial.controller;

import com.vijaypai.springboot.tutorial.entity.Department;
import com.vijaypai.springboot.tutorial.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.web.JsonPath;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private DepartmentService departmentService;
    private Department department;

    @BeforeEach
    void setUp() {
        department = Department.builder()
                .departmentId(1L)
                .departmentName("BS")
                .departmentAddress("Tesco Bengaluru")
                .departmentCode("T-12")
                .build();
    }

    @Test
    void createDepartment() throws Exception {
        Department inputDepartment = Department.builder()
                //.departmentId(1L)
                .departmentName("BS")
                .departmentAddress("Tesco Bengaluru")
                .departmentCode("T-12")
                .build();

        Mockito.when(departmentService.createServiceDepartment(inputDepartment))
                .thenReturn(department);

        //to mock POST endpoint
        mockMvc.perform(MockMvcRequestBuilders.post("/departments")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "    \"departmentName\":\"BS\",\n" +
                                "    \"departmentAddress\":\"Tesco Bengaluru\",\n" +
                                "    \"departmentCode\":\"T-12\"\n" +
                                "}"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void searchDepartment() throws Exception {
        Mockito.when(departmentService.searchServiceDepartment(1L))
                .thenReturn(department);

        mockMvc.perform(MockMvcRequestBuilders.get("/departments/1")
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.departmentName")
                        .value(department.getDepartmentName()));
    }
}