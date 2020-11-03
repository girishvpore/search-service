package com.girishpore.searchservice.controller;

import com.girishpore.searchservice.model.Employee;
import com.girishpore.searchservice.service.EmployeeService;
import static org.hamcrest.CoreMatchers.is;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;


@WebMvcTest(controllers = EmployeeController.class)
@ActiveProfiles("test")
public class EmployeeControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeService service;

    List<Employee> employees;

    @BeforeEach
    void setUp() {
        employees = new ArrayList<>();
        employees.add(Employee.builder().ackId("20180919134812P040129431469001").businessCode("311610")
                .ein("362762569").planName("CAPITOL WHOLESALE MEATS, INC. PROFIT SHARING AND RETIREMENT PLAN")
                .sponsorName("CAPITOL WHOLESALE MEATS, INC.")
                .sponsorState("IL")
                .build());

    }

    @Test
    public void searchByPlanNameTest() throws Exception {
        when(service.findByPlanName(anyString(), anyInt(), anyInt())).thenReturn(employees);
        callAndVerify("/employees/search/byPlanName", "0", "1", "CAPITOL WHOLESALE MEATS, INC. PROFIT SHARING AND RETIREMENT PLAN");

    }

    @Test
    public void searchBySponsorState() throws Exception {
        when(service.findBySponsorState(anyString(), anyInt(), anyInt())).thenReturn(employees);
        callAndVerify("/employees/search/bySponsorState", "0", "1", "IL");

    }

    @Test
    public void searchBySponsorName() throws Exception {
        when(service.findBySponsorName(anyString(), anyInt(), anyInt())).thenReturn(employees);
        callAndVerify("/employees/search/bySponsorName", "0", "1", "CAPITOL WHOLESALE MEATS, INC.");

    }

    private void callAndVerify(String url, String offset, String size, String value) throws Exception {
        this.mockMvc.perform(get(url)
                .param("offset", offset)
                .param("size", size)
                .param("value", value))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.[0].ein", is("362762569")))
                .andExpect(jsonPath("$.[0].planName", is("CAPITOL WHOLESALE MEATS, INC. PROFIT SHARING AND RETIREMENT PLAN")));
    }
}

