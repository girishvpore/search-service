package com.girishpore.searchservice.dao;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

/**
 * Data object to store values returned by elastic search
 */
@Data
@Builder
@Document(indexName = "emp_benefits", createIndex = false)
public class EmployeeDO {
    @Id
    private String id;
    @Field(name = "ACK_ID")
    private String ackId;
    @Field(name = "SPONS_DFE_EIN")
    private String ein;
    @Field(name = "PLAN_NAME")
    private String planName;
    @Field(name = "SPONSOR_DFE_NAME")
    private String sponsorName;
    @Field(name = "SPONS_DFE_MAIL_US_STATE")
    private String sponsorState;
    @Field(name = "BUSINESS_CODE")
    private String businessCode;
}
