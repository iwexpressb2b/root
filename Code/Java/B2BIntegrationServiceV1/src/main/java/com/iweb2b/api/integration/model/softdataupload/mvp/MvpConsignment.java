package com.iweb2b.api.integration.model.softdataupload.mvp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/*
 *  {
        "consignments": [{
               "customer_code": "ASD",
               "reference_number": "",
               "service_type_id": "PREMIUM",
               "consignment_type": "forward",
               "load_type": "DOCUMENT",
               "description": "Sports Nutrition",
               "cod_favor_of": "",
               "cod_collection_mode": "dd",
               "dimension_unit": "cm",
               "length": "",
               "width": "",
               "height": "",
               "weight_unit": "kg",
               "weight": 2.63,
               "declared_value": 146,
               "cod_amount": "0.000",
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
@Table(name = "tblmvpconsignment")
public class MvpConsignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MVP_CONSIGNMENT_ID")
    private Long mvpConsignmentId;
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
    @Column(name="COD_COLLECTION_MODE")
	private String cod_collection_mode;
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
    @Column(name="COD_AMOUNT")
    private String cod_amount;
    @Column(name="NUM_PIECES")
    private Long num_pieces;
    @Column(name="NOTES")
    private String notes;
    @Column(name="CUSTOMER_REFERENCE_NUMBER")
    private String customer_reference_number;
    @Column(name="IS_RISK_SURCHARGE_APPLICABLE")
    private Boolean is_risk_surcharge_applicable;
    
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "mvpConsignmentId",fetch = FetchType.EAGER)
    private Set<MvpOrigin_Details> origin_details;
	
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "mvpConsignmentId",fetch = FetchType.EAGER)
    private Set<MvpDestination_Details> destination_details;
    
//    @OneToMany(cascade = CascadeType.ALL,mappedBy = "softDataUploadId",fetch = FetchType.EAGER)
//    private Set<Origin_Details> origin_details;
//	
//	@OneToMany(cascade = CascadeType.ALL,mappedBy = "softDataUploadId",fetch = FetchType.EAGER)
//    private Set<Destination_Details> destination_details;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "mvpConsignmentId",fetch = FetchType.EAGER)
    private Set<MvpPieces_Details> pieces_detail;

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

    @Column(name = "CTD_BY")
    private String createdBy;

    @Column(name = "CTD_ON")
    private Date createdOn;

    @Column(name = "UTD_BY")
    private String updatedBy;

    @Column(name = "UTD_ON")
    private Date updatedOn;
}
