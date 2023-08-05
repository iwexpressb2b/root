package com.iweb2b.api.integration.model.tracking;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tblevent")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name="CONSIGNMENT_TRACKING_ID")
    private Long consignmentTrackingId;

    @Column(name="TYPE")
    private String type;
    @Column(name="EVENT_DESCRIPTION")
    private String event_description;
    @Column(name="EVENT_TIME")
    private Date event_time;
    @Column(name="HUB_NAME")
    private String hub_name;
    @Column(name="HUB_CODE")
    private String hub_code;
    @Column(name="FAILURE_REASON")
    private String failure_reason;
    @Column(name="WORKER_NAME")
    private String worker_name;
    @Column(name="WORKER_CODE")
    private String worker_code;
    @Column(name="EMPLOYEE_CODE")
    private String employee_code;
    @Column(name="EMPLOYEE_NAME")
    private String employee_name;
    @Column(name="LATITUDE")
    private String latitude;
    @Column(name="LONGITUDE")
    private String longitude;
    @Column(name="CUSTOMER_UPDATE")
    private String customer_update;
    @Column(name="EXECUTION_STATUS")
    private String execution_status;
    @Column(name="STATUS_EXTERNAL")
    private String status_external;
    @Column(name="CARRIER_LOCATION_CODE")
    private String carrier_location_code;
    @Column(name="POP_IMAGE")
    private String pop_image;
    @Column(name="POC_IMAGE")
    private String poc_image;

    @Column(name = "IS_DELETED")
    private Long deletionIndicator = 0L;

    @Column(name = "REF_FIELD_1")
    private String referenceField1;

    @Column(name = "REF_FIELD_2")
    private String referenceField2;

    @Column(name = "REF_FIELD_3")
    private String referenceField3;

    @Column(name = "REF_FIELD_4")
    private String referenceField4;

    @Column(name = "REF_FIELD_5")
    private String referenceField5;

    @Column(name = "REF_FIELD_6")
    private String referenceField6;

    @Column(name = "REF_FIELD_7")
    private String referenceField7;

    @Column(name = "REF_FIELD_8")
    private String referenceField8;

    @Column(name = "REF_FIELD_9")
    private String referenceField9;

    @Column(name = "REF_FIELD_10")
    private String referenceField10;

    @Column(name = "CTD_BY")
    private String createdBy;

    @Column(name = "CTD_ON")
    private Date createdOn;

    @Column(name = "UTD_BY")
    private String updatedBy;

    @Column(name = "UTD_ON")
    private Date updatedOn;
}
