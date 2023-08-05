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
@Table(name = "tblorigindetail")
public class Origin_Details {

	/*
	 * "origin_details": { "name": "The Hut Group", "phone": "97101606811863",
	 * "alternate_phone": "", "address_line_1":
	 * "Mohebi Logistics; Plot WT01 & WT04", "address_line_2":
	 * "LF Logistics/Mohebi Logistics, Plot", "pincode": "8005", "city": "Dubai",
	 * "state": "", "country": "AE" },
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "CONSIGNMENT_ID")
	private Long consignmentId;

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
}
