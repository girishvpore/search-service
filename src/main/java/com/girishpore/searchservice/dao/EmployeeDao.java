package com.girishpore.searchservice.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring data extended interface to get data from elasic search
 */
@Repository
public interface EmployeeDao extends ElasticsearchRepository<EmployeeDO, String> {

    /**
     * @param planName plan name to be searched
     * @param pageable page attributes
     * @return Page of searched data
     */
    Page<EmployeeDO> findByPlanName(String planName, Pageable pageable);

    /**
     * @param sponsorName plan name to be searched
     * @param pageable    page attributes
     * @return Page of searched data
     */
    Page<EmployeeDO> findBySponsorName(String sponsorName, Pageable pageable);

    /**
     * @param sponsorState plan name to be searched
     * @param pageable     page attributes
     * @return Page of searched data
     */
    Page<EmployeeDO> findBySponsorState(String sponsorState, Pageable pageable);
}
