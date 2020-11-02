package com.girishpore.searchservice.service;

import com.girishpore.searchservice.model.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findByPlanName(String value, int size, int offset);

    List<Employee> findBySponsorName(String value, int size, int offset);

    List<Employee> findBySponsorState(String value, int size, int offset);
}
