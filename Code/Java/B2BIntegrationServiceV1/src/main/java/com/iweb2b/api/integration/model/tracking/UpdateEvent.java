package com.iweb2b.api.integration.model.tracking;

import lombok.Data;

import java.util.Date;

@Data
public class UpdateEvent {

    private String type;

    private String event_description;

    private Date event_time;

    private String hub_name;

    private String hub_code;

    private String failure_reason;

    private String worker_name;

    private String worker_code;

    private String employee_code;

    private String employee_name;

    private String latitude;

    private String longitude;

    private String customer_update;

    private String execution_status;

    private String status_external;

    private String carrier_location_code;

    private String pop_image;

    private String poc_image;


    private Long deletionIndicator = 0L;
    private String referenceField1;
    private String referenceField2;
    private String referenceField3;
    private String referenceField4;
    private String referenceField5;
    private String referenceField6;
    private String referenceField7;
    private String referenceField8;
    private String referenceField9;
    private String referenceField10;
    private String createdBy;
    private Date createdOn;
    private String updatedBy;
    private Date updatedOn;
}
