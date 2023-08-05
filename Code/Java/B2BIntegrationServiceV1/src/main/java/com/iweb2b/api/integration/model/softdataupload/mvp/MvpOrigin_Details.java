package com.iweb2b.api.integration.model.softdataupload.mvp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tblmvporigindetails")
public class MvpOrigin_Details {
	
	/*
	 * "origin_details": {
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
	 */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORIGIN_DETAILS_ID")
    private Long originId;
    @Column(name = "MVP_CONSIGNMENT_ID")
    private Long mvpConsignmentId;
    @Column(name = "NAME")
	private String name;
    @Column(name = "PHONE")
    private String phone;
    @Column(name = "ALTERNATE_PHONE")
    private String alternate_phone;
    @Column(name = "ADDRESS_LINE_1")
    private String address_line_1;
    @Column(name = "ADDRESS_LINE_2")
    private String address_line_2;
    @Column(name = "PINCODE")
    private String pincode;
    @Column(name = "CITY")
    private String city;
    @Column(name = "STATE")
    private String state;
    @Column(name = "COUNTRY")
    private String country;

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
