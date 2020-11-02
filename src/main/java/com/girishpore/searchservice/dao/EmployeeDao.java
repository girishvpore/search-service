package com.girishpore.searchservice.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface EmployeeDao  extends ElasticsearchRepository<EmployeeDO, String> {

    Page<EmployeeDO> findByPlanName(String planName, Pageable pageable);

    Page<EmployeeDO> findBySponsorName(String planName, Pageable pageable);

    Page<EmployeeDO> findBySponsorState(String planName, Pageable pageable);
}
