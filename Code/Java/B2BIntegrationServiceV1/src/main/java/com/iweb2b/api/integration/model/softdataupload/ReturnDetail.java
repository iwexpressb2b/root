package com.iweb2b.api.integration.model.softdataupload;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tblreturndetail")
public class ReturnDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "SOFT_DATA_UPLOAD_ID")
	private Long softDataUploadId;

	@Column(name="ADDRESS_HUB_CODE")
	private String addressHubCode;
	@Column(name="NAME")
	private String name;
	@Column(name="PHONE")
	private String phone;
	@Column(name="ALTERNATE_PHONE")
	private String alternatePhone;
	@Column(name="ADDRESS_LINE_1")
	private String addressLine1;
	@Column(name="ADDRESS_LINE_2")
	private String addressLine2;
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