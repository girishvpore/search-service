package com.girishpore.searchservice.service;

import com.girishpore.searchservice.dao.EmployeeDO;
import com.girishpore.searchservice.dao.EmployeeDao;
import com.girishpore.searchservice.model.Employee;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.Collections;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceImplTest {

    @Mock
    private EmployeeDao employeeDao;
    private EmployeeServiceImpl service;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void findBySponsorName() {
        {
            when(employeeDao.findByPlanName(anyString(), any())).thenReturn(getEmployeeDO());
            List<Employee> employees = service.findBySponsorName(eq("NIEMAN PRINTING, INC"), eq(1), eq(0));
            validateResult(employees);
        }
    }

    @Test
    public void findByPlanName() {
        {
            when(employeeDao.findByPlanName(anyString(), any())).thenReturn(getEmployeeDO());
            List<Employee> employees = service.findByPlanName(eq("NIEMAN PRINTING, INC. 401(K) PLAN"), eq(1), eq(0));
            validateResult(employees);
        }
    }

    @Test
    public void findBySponsorState() {
        {
            when(employeeDao.findByPlanName(anyString(), any())).thenReturn(getEmployeeDO());
            List<Employee> employees = service.findBySponsorState(eq("TX"), eq(1), eq(0));
            validateResult(employees);
        }
    }

    private void validateResult(List<Employee> employees) {
        assertNotNull(employees);
        assertEquals(employees.size(), 1);
        assertEquals(employees.get(0).getAckId(), "20180731102549P040046454015001");
        assertEquals(employees.get(0).getBusinessCode(), "312140");
        assertEquals(employees.get(0).getEin(), "751598846");
        assertEquals(employees.get(0).getPlanName(), "NIEMAN PRINTING, INC. 401(K) PLAN");
        assertEquals(employees.get(0).getSponsorName(), "NIEMAN PRINTING, INC");
        assertEquals(employees.get(0).getSponsorState(), "TX");
    }

    private Page<EmployeeDO> getEmployeeDO() {
        return new PageImpl<EmployeeDO>(Collections.singletonList(EmployeeDO
                .builder().ackId("20180731102549P040046454015001")
                .ein("751598846").businessCode("312140")
                .planName("NIEMAN PRINTING, INC. 401(K) PLAN").sponsorName("NIEMAN PRINTING, INC")
                .sponsorState("TX").build()));
    }

}