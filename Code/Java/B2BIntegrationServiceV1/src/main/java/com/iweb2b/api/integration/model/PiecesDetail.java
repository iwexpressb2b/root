package com.iweb2b.api.integration.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tblpiecesdetail2")
public class PiecesDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name="CONSIGNMENT_TRACKING_ID")
    private Long consignmentTrackingId;

    @Column(name = "SOFT_DATA_UPLOAD_ID")
    private Long softDataUploadId;

    @Column(name="DESCRIPTION")
    private String description;
    
    @Column(name="DECLARED_VALUE")
    private String declared_value;
    
    @Column(name="VOLUME")
    private String volume;
    
    @Column(name="WEIGHT")
    private String weight;
    
    @Column(name="HEIGHT")
    private String height;
    
    @Column(name="LENGTH")
    private String length;
    
    @Column(name="WIDTH")
    private String width;
    
    @Column(name="WEIGHT_UNIT")
    private String weight_unit;
    
    @Column(name="DIMENSION_UNIT")
    private String dimension_unit;
    
    @Column(name="VOLUME_UNIT")
    private String volume_unit;
    
    @Column(name="PIECE_PRODUCT_CODE")
    private String piece_product_code;

    @Column(name="CHARGEABLE_WEIGHT")
    private Long chargeable_weight;

    @Column(name="VOLUMETRIC_WEIGHT")
    private Long volumetric_weight;

    @Column(name="DENORMALIZED_WIDTH")
    private Long denormalized_width;

    @Column(name="DENORMALIZED_HEIGHT")
    private Long denormalized_height;

    @Column(name="DENORMALIZED_LENGTH")
    private Long denormalized_length;

    @Column(name="DENORMALIZED_VOLUME")
    private Long denormalized_volume;

    @Column(name="DENORMALIZED_WEIGHT")
    private Double denormalized_weight;

    @Column(name="DENORMALIZED_VOLUME_UNIT")
    private String denormalized_volume_unit;

    @Column(name="DENORMALIZED_WEIGHT_UNIT")
    private String denormalized_weight_unit;

    @Column(name="DENORMALIZED_DIMENSION_UNIT")
    private String denormalized_dimension_unit;

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
