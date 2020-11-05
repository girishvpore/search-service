package com.girishpore.searchservice.service;

import com.girishpore.searchservice.model.Employee;

import java.util.List;

public interface EmployeeService {
    /**
     * @param value  plan name to be searched
     * @param size   size of page
     * @param offset page number
     * @return List of Employees
     */
    List<Employee> findByPlanName(String value, int size, int offset);

    /**
     * @param value  sponsor name to be searched
     * @param size   size of page
     * @param offset page number
     * @return List of Employees
     */
    List<Employee> findBySponsorName(String value, int size, int offset);

    /**
     * @param value  sponsor state to be searched
     * @param size   size of page
     * @param offset page number
     * @return List of Employees
     */
    List<Employee> findBySponsorState(String value, int size, int offset);
}
