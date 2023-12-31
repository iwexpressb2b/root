package com.iweb2b.api.master.model.partnermaster;

import lombok.Data;

@Data
public class UpdatePartnerMaster {

	private String partnerId;
	
	private String partnerName;
	
	private String subscriptionType;
	
	private String partnerType;
	
	private String apiKey;
	
	private String organisation;
	
	private String sourceSystem;
	
	private String targetSystem;
	
	private Long deletionIndicator;

	private String referenceField1;

	private String referenceField2;

	private String referenceField3;

	private String referenceField4;

	private String referenceField5;

	private String referenceField6;

	private String referenceField7;

	private String referenceField8;

	private String referenceField9;

	private String referenceField10;
	
	private String updatedBy;
}
