package com.iweb2b.api.integration.model.consignment.dto;

import lombok.Data;

@Data
public class DashboardCountOutput {

    private Long boutiqaatPassCount;
    private Long boutiqaatFailCount;
    private Long jntPassCount;
    private Long jntFailCount;
    private Long iwintlPassCount;
    private Long iwintlFailCount;
}