package com.girishpore.searchservice.controller;

import com.girishpore.searchservice.model.Employee;
import com.girishpore.searchservice.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Rest service with endpoints to search with Plan name, Sponsor name , Sponsor state
 * This has ability to do pagination
 */
@RestController
@RequestMapping("/employees")
@Slf4j
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    /**
     *
     * @param value plan name to be searched
     * @param size size of page
     * @param offset page number
     * @return List of employees which satisfies the search criteria
     */
    @GetMapping(value = "/search/byPlanName", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Employee>> searchByPlanName(@RequestParam(value = "value") String value,
                                                           @RequestParam(value = "size", defaultValue = "5", required = false) int size,
                                                           @RequestParam(value = "offset", defaultValue = "0", required = false) int offset) {

        List<Employee> employeeList = service.findByPlanName(value, size, offset);
        return ResponseEntity.status(HttpStatus.OK).body(employeeList);
    }

    /**
     *
     * @param value sponsor name to be searched
     * @param size size of page
     * @param offset page number
     * @return List of employees which satisfies the search criteria
     */
    @GetMapping(value = "/search/bySponsorName", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Employee>> searchBySponsorName(@RequestParam(value = "value") String value,
                                                              @RequestParam(value = "size", defaultValue = "5", required = false) int size,
                                                              @RequestParam(value = "offset", defaultValue = "0", required = false) int offset) {

        List<Employee> employeeList = service.findBySponsorName(value, size, offset);
        return ResponseEntity.status(HttpStatus.OK).body(employeeList);
    }

    /**
     *
     * @param value sponsor state to be searched
     * @param size size of page
     * @param offset page number
     * @return List of employees which satisfies the search criteria
     */
    @GetMapping(value = "/search/bySponsorState", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Employee>> searchBySponsorState(@RequestParam(value = "value") String value,
                                                               @RequestParam(value = "size", defaultValue = "5", required = false) int size,
                                                               @RequestParam(value = "offset", defaultValue = "0", required = false) int offset) {

        List<Employee> employeeList = service.findBySponsorState(value, size, offset);
        return ResponseEntity.status(HttpStatus.OK).body(employeeList);
    }
}