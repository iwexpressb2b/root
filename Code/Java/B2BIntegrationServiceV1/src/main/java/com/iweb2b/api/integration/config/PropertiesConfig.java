package com.iweb2b.api.integration.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import lombok.Data;

@Data
@Configuration
@PropertySource("classpath:application-messages.properties")
public class PropertiesConfig {

	@Value("${master.oauth.credentials.client_id}")
	private String clientId;
	
	@Value("${master.oauth.credentials.client_secret_key}")
	private String clientSecretKey;
	
	@Value("${master.oauth.grant_type}")
	private String grantType;
	
	@Value("${master.oauth.grant_type.username}")
	private String username;
	
	@Value("${master.oauth.grant_type.password}")
	private String password;
	
	//-----------------------------------------------------------------------------------
	@Value("${api.master.service.url}")
	private String masterServiceUrl;
	
	//---------------------Shipsy APIs---------------------------------------------------
	// shipsy.api.server=https://demodashboardapi.shipsy.in
	@Value("${shipsy.api.server}")
	private String shipsyApiServer;
	
	// shipsy.api.auth.token
	@Value("${shipsy.api.auth.token}")
	private String shipsyApiAuthtoken;
	
	//------------------Softdata upload--------------------------------------------------
	// shipsy.api.softdata.upload=/api/client/integration/consignment/upload/softdata/v2
	@Value("${shipsy.api.softdata.upload}")
	private String shipsyApiSoftdataUpload;
	
	// shipsy.api.softdata.update=/api/client/integration/consignment/v1/update
	@Value("${shipsy.api.softdata.update}")
	private String shipsyApiSoftdataUpdate;
	
	//------------------Consignment Tracking---------------------------------------------
	// shipsy.api.consignment.tracking=/api/client/integration/consignment/track
	@Value("${shipsy.api.consignment.tracking}")
	private String shipsyApiConsignmentTracking;
	
	// shipsy.api.order.cancel=/api/client/integration/consignment/cancellation
	@Value("${shipsy.api.order.cancel}")
	private String shipsyApiOrderCancel;
	
	//------------------Client Label Generation Upload-----------------------------------
	// shipsy.api.labelgen=/api/client/integration/consignment/shippinglabel/stream
	@Value("${shipsy.api.labelgen}")
	private String shipsyApiLabelGen;
	
	//------------------Asyad Webhook----------------------------------------------------
	// shipsy.api.asyad.webhook=https://apix.asyadexpress.com/v2/webhooks/incoming-integration
	@Value("${shipsy.api.asyad.webhook}")
	private String shipsyApiAsyadWebhook;
}
