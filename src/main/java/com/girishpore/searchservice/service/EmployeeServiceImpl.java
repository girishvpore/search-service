package com.girishpore.searchservice.service;

import com.girishpore.searchservice.dao.EmployeeDO;
import com.girishpore.searchservice.dao.EmployeeDao;
import com.girishpore.searchservice.exception.SearchException;
import com.girishpore.searchservice.mapper.DoToBoMapper;
import com.girishpore.searchservice.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService{
    private final EmployeeDao employeeDao;

    public EmployeeServiceImpl(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public List<Employee> findByPlanName(String value, int size, int offset) {
        log.info("Searching employess by plan name");
        Page<EmployeeDO> employeeDOPage= employeeDao.findByPlanName(value,PageRequest.of(offset,size));
        if (employeeDOPage.isEmpty()) {
            throw new SearchException(HttpStatus.NOT_FOUND);
        }
        log.info(String.format("findByPlanName Total elements : %d", employeeDOPage.getTotalElements(),employeeDOPage.getTotalPages()));
        return DoToBoMapper.INSTANCE.map(employeeDOPage.getContent().stream().collect(Collectors.toList()));
    }

    @Override
    public List<Employee> findBySponsorName(String value, int size, int offset) {
        log.info("Searching employess by sponsor name");
        Page<EmployeeDO> employeeDOPage= employeeDao.findBySponsorName(value,PageRequest.of(offset,size));
        if (employeeDOPage.isEmpty()) {
            throw new SearchException(HttpStatus.NOT_FOUND);
        }
        log.info(String.format("findByPlanName Total elements : %d", employeeDOPage.getTotalElements(),employeeDOPage.getTotalPages()));
        return DoToBoMapper.INSTANCE.map(employeeDOPage.getContent().stream().collect(Collectors.toList()));
    }

    @Override
    public List<Employee> findBySponsorState(String value, int size, int offset) {
        log.info("Searching employess by sponsor state");
        Page<EmployeeDO> employeeDOPage= employeeDao.findBySponsorState(value,PageRequest.of(offset,size));
        if (employeeDOPage.isEmpty()) {
            throw new SearchException(HttpStatus.NOT_FOUND);
        }
        log.info(String.format("findByPlanName Total elements : %d", employeeDOPage.getTotalElements(),employeeDOPage.getTotalPages()));
        return DoToBoMapper.INSTANCE.map(employeeDOPage.getContent().stream().collect(Collectors.toList()));
    }
}