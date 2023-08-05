package com.iweb2b.api.integration.model.softdataupload.client;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 *  {
        "consignments": [{
       			"cod_amount": "0.000",
        		"cod_collection_mode": "dd",
        		"cod_favor_of": "",
        
               "customer_code": "ASD",
               "reference_number": "",
               "service_type_id": "PREMIUM",
               "consignment_type": "forward",
               "load_type": "DOCUMENT",
               "description": "Sports Nutrition",
               
               
               "dimension_unit": "cm",
               "length": "",
               "width": "",
               "height": "",
               "weight_unit": "kg",
               "weight": 2.63,
               "declared_value": 146,
               
               "num_pieces": 1,
               "notes": "Sports Nutrition",
               "customer_reference_number": "296163854",
               "is_risk_surcharge_applicable": false,
               "origin_details": {
                       "name": "The Hut Group",
                       "phone": "97101606811863",
                       "alternate_phone": "",
                       "address_line_1": "Mohebi Logistics; Plot WT01 & WT04",
                       "address_line_2": "LF Logistics/Mohebi Logistics, Plot",
                       "pincode": "8005",
                       "city": "Dubai",
                       "state": "",
                       "country": "AE"
               },

               "destination_details": {
                       "name": "Mohammad Alsmaim",
                       "phone": "96597990399",
                       "alternate_phone": "",
                       "address_line_1": "house 61 Block 5, street 517",
                       "address_line_2": "",
                       "pincode": "91710",
                       "city": "Jaber Alahmad",
                       "state": "",
                       "country": "KW"
               },

               "pieces_detail": [{
                       "description": "Sports Nutrition",
                       "declared_value": 0,
                       "weight": 2.63,
                       "height": 18,
                       "length": 11,
                       "width": 13
               }]
        }]
	}
 */
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tblconsignment")
public class Consignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CONSIGNMENT_ID")
    private Long consignmentId;

    @Column(name="COD_AMOUNT")
	private String cod_amount;

    @Column(name="COD_COLLECTION_MODE")
	private String cod_collection_mode;

    @Column(name="CUSTOMER_CODE")
	private String customer_code;

    @Column(name="SERVICE_TYPE_ID")
	private String service_type_id;

    @Column(name="CONSIGNMENT_TYPE")
	private String consignment_type;

    @Column(name="LOAD_TYPE")
	private String load_type;

    @Column(name="DESCRIPTION")
	private String description;

    @Column(name="COD_FAVOR_OF")
	private String cod_favor_of;

    @Column(name="DIMENSION_UNIT")
	private String dimension_unit;

    @Column(name="LENGTH")
	private String length;

    @Column(name="WIDTH")
    private String width;

    @Column(name="HEIGHT")
    private String height;

    @Column(name="WEIGHT_UNIT")
    private String weight_unit;

    @Column(name="WEIGHT")
    private Double weight;

    @Column(name="DECLARED_VALUE")
    private Double declared_value;

    @Column(name="NUM_PIECES")
    private Long num_pieces;

    @Column(name="NOTES")
    private String notes;

    @Column(name="CUSTOMER_REFERENCE_NUMBER")
    private String customer_reference_number;

    @Column(name="IS_RISK_SURCHARGE_APPLICABLE")
    private Boolean is_risk_surcharge_applicable;
    
	@OneToOne(cascade = CascadeType.ALL,mappedBy = "consignmentId",fetch = FetchType.EAGER)
    private Origin_Details origin_details;
	
    @OneToOne(cascade = CascadeType.ALL,mappedBy = "consignmentId",fetch = FetchType.EAGER)
    private Destination_Details destination_details;
    
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "consignmentId",fetch = FetchType.EAGER)
    private Set<Pieces_Details> pieces_detail;
}
