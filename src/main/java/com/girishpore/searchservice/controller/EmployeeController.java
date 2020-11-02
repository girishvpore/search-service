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

@RestController
@RequestMapping("/employees")
@Slf4j
public class EmployeeController {

    @Autowired
    private EmployeeService service;


    @GetMapping(value = "/search/byPlanName", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Employee>> searchByPlanName(@RequestParam(value = "value") String value,
                                                 @RequestParam(value = "size" ,defaultValue = "5", required = false) int size,
                                                 @RequestParam(value = "offset" ,defaultValue = "0", required = false) int offset){

        List<Employee> employeeList= service.findByPlanName(value,size,offset);
        return ResponseEntity.status(HttpStatus.OK).body(employeeList);
    }

    @GetMapping(value = "/search/bySponsorName", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Employee>> searchBySponsorName(@RequestParam(value = "value") String value,
                                                           @RequestParam(value = "size",defaultValue = "5", required = false) int size,
                                                           @RequestParam(value = "offset" ,defaultValue = "0", required = false) int offset){

        List<Employee> employeeList= service.findBySponsorName(value,size,offset);
        return ResponseEntity.status(HttpStatus.OK).body(employeeList);
    }
    @GetMapping(value = "/search/bySponsorState", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Employee>> searchBySponsorState(@RequestParam(value = "value") String value,
                                                           @RequestParam(value = "size" ,defaultValue = "5", required = false) int size,
                                                           @RequestParam(value = "offset" ,defaultValue = "0", required = false) int offset){

        List<Employee> employeeList= service.findBySponsorState(value,size,offset);
        return ResponseEntity.status(HttpStatus.OK).body(employeeList);
    }
}