package com.intech.session3;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.intech.session3.domain.Employee;
import com.intech.session3.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class EmployeeControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    private EmployeeService employeeService;

    @Test
    public void employeeSaveTest() throws Exception {
        Employee employee=Employee.builder()
                .name("XYZ")
                .department("IT")
                .city("Pune")
                .build();
        //configuration part
        given(employeeService.save(any(Employee.class)))
                .willAnswer(invocation -> invocation.getArgument(0));
        //result part
        ResultActions response=mockMvc.perform(post("/api/v1/employee")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(employee)));
        response.andDo(print())
                //
                .andExpect(status().isCreated())
                //check expected return
                .andExpect(jsonPath("$.name",is(employee.getName())));
    }

}
