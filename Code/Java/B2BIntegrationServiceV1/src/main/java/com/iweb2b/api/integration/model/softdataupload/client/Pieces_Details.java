package com.iweb2b.api.integration.model.softdataupload.client;

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
@Table(name = "tblpiecesdetail")
public class Pieces_Details {
	
	/*
	 * 		{
               "description": "Sports Nutrition",
               "declared_value": 0,
               "weight": 2.63,
               "height": 18,
               "length": 11,
               "width": 13
          	}
	 */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name="CONSIGNMENT_ID")
    private Long consignmentId;

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
}