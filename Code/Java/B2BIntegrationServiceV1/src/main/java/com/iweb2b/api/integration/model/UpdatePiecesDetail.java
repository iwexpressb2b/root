package com.iweb2b.api.integration.model;

import lombok.Data;

@Data
public class UpdatePiecesDetail {

    private String description;
    private String declared_value;
    private String volume;
    private String weight;
    private String height;
    private String length;
    private String width;
    private String weight_unit;
    private String dimension_unit;
    private String volume_unit;
    private String piece_product_code;

    private Long chargeable_weight;
    private Long volumetric_weight;
    private Long denormalized_width;
    private Long denormalized_height;
    private Long denormalized_length;
    private Long denormalized_volume;
    private Double denormalized_weight;
    private String denormalized_volume_unit;
    private String denormalized_weight_unit;
    private String denormalized_dimension_unit;

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
