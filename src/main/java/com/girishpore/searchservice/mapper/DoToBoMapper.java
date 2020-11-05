package com.girishpore.searchservice.mapper;

import com.girishpore.searchservice.dao.EmployeeDO;
import com.girishpore.searchservice.model.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * Map struct mapper to convert EmployeeDO to Employee class
 */
@Mapper
public interface DoToBoMapper {
    DoToBoMapper INSTANCE = Mappers.getMapper(DoToBoMapper.class);

    Employee map(EmployeeDO employeeDO);

    List<Employee> map(List<EmployeeDO> dos);
}

