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
@Table(name = "tbldestinationdetail")
public class Destination_Details {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id")
	    private Long id;

	    @Column(name="CONSIGNMENT_ID")
	    private Long consignmentId;

	    @Column(name="ADDRESS_HUB_CODE")
	    private String address_hub_code;
	    
	    @Column(name="NAME")
	    private String name;
	    
	    @Column(name="PHONE")
	    private String phone;
	    
	    @Column(name="ALTERNATE_PHONE")
	    private String alternate_phone;
	    
	    @Column(name="ADDRESS_LINE_1")
	    private String address_line_1;
	    
	    @Column(name="ADDRESS_LINE_2")
	    private String address_line_2;
	    
	    @Column(name="PINCODE")
	    private String pincode;
	    
	    @Column(name="DISTRICT")
	    private String district;
	    
	    @Column(name="CITY")
	    private String city;
	    
	    @Column(name="STATE")
	    private String state;
	    
	    @Column(name="COUNTRY")
	    private String country;
	    
	    @Column(name="LATITUDE")
	    private String latitude;
	    
	    @Column(name="LONGITUDE")
	    private String longitude;
}
