package com.iweb2b.api.master.model.monitoring;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class AddSystemMonitoringDeck {

	@NotBlank(message = "Partner ID is mandatory")
	private String partnerId;
	
	@NotNull(message = "Partner Name is mandatory")
	private String partnerName;
	
	private String alerts;
	
	private String requestResponse;

	private String documentCreationFailure;
	
	private String systemIssues;
	
	private String systemApiFailures;
	
	@NotBlank(message = "System Downtime is mandatory")
	private String systemDowntime;
	
	private String heatMap;
				
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
