package com.iweb2b.api.integration.model;

import lombok.Data;

@Data
public class UpdateDestinationDetail {

    private String address_hub_code;
    private String name;
    private String phone;
    private String alternate_phone;
    private String address_line_1;
    private String address_line_2;
    private String pincode;
    private String district;
    private String city;
    private String state;
    private String country;
    private String latitude;
    private String longitude;

    private Long deletionIndicator;

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

    private String updatedBy;
}
