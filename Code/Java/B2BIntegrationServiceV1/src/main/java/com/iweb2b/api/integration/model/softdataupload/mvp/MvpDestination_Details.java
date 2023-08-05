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
@Table(name = "tblmvpdestinationdetails")
public class MvpDestination_Details {
	
	/*
	 * 		{
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
	 */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DESTINATION_ID")
    private Long destinationId;

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
