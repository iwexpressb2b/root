package com.iweb2b.api.integration.model.softdataupload.asyad;

import lombok.Data;

@Data
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
}
