package com.girishpore.searchservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
/**
 * This class represents some employee attributes used to demonstrate search result
 */
public class Employee {
    /**
     * SPONS_DFE_EIN
     */
    private String ein;
    /**
     * PLAN_NAME
     */
    private String planName;
    /**
     * SPONSOR_DFE_NAME
     */
    private String sponsorName;
    /**
     * SPONS_DFE_MAIL_US_STATE
     */
    private String sponsorState;
    /**
     * ACK_ID
     */
    private String ackId;
    /**
     * BUSINESS_CODE
     */
    private String businessCode;
}