package com.iweb2b.api.integration.service;

import java.util.Arrays;
import java.util.Collections;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.iweb2b.api.integration.config.PropertiesConfig;
import com.iweb2b.api.integration.model.softdataupload.ClientCancelOrderRequest;
import com.iweb2b.api.integration.model.softdataupload.ClientCancelOrderResponse;
import com.iweb2b.api.integration.model.softdataupload.ClientSoftdataUpdateRequest;
import com.iweb2b.api.integration.model.softdataupload.ClientSoftdataUpdateResponse;
import com.iweb2b.api.integration.model.softdataupload.SoftDataUpload;
import com.iweb2b.api.integration.model.softdataupload.client.Consignment;
import com.iweb2b.api.integration.model.softdataupload.client.ConsignmentResponse;
import com.iweb2b.api.integration.model.tracking.ConsignmentTracking;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class IntegrationService {
	
	@Autowired
	PropertiesConfig propertiesConfig;
	
	/**
	 * Returns RestTemplate Object
	 * @return
	 */
	public RestTemplate getRestTemplate() {
		RestTemplate restTemplate = new RestTemplate();

		// Object Convertor
		MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
		mappingJackson2HttpMessageConverter
				.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON, MediaType.APPLICATION_OCTET_STREAM));
		restTemplate.getMessageConverters().add(mappingJackson2HttpMessageConverter);
		return restTemplate;
	}
	
	/**
	 * POST - ClientSoftdataUpload
	 * @param softDataUpload
	 * @return
	 */
	public ConsignmentResponse postClientSoftdataUpload (Consignment newConsignment) {
		// Invoke Shipsy API
		try {
			String authToken = propertiesConfig.getShipsyApiAuthtoken();
			String softdataUrl = propertiesConfig.getShipsyApiServer() + propertiesConfig.getShipsyApiSoftdataUpload();
			log.info("URL:" + softdataUrl);
			log.info("AuthToken:" + authToken);
			
			HttpHeaders headers = new HttpHeaders();
			headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
			headers.add("User-Agent", "B2B_IW_PortalRestTemplate");
			headers.add("Authorization", "Basic " + authToken);
			HttpEntity<?> entity = new HttpEntity<>(newConsignment, headers);
			
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(softdataUrl);
			ResponseEntity<ConsignmentResponse> result = 
					getRestTemplate().exchange(builder.toUriString(), HttpMethod.POST, entity, ConsignmentResponse.class);
			log.info("result:-------> : " + result);
			return result.getBody();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	/**
	 * 
	 * @param clientSoftdataUpdateRequest
	 * @return
	 */
	public ClientSoftdataUpdateResponse postClientSoftdataUpdate (ClientSoftdataUpdateRequest clientSoftdataUpdateRequest) {
		// Invoke Shipsy API
		String authToken = propertiesConfig.getShipsyApiAuthtoken();
		String softdataUrl = propertiesConfig.getShipsyApiServer() + "/" + propertiesConfig.getShipsyApiSoftdataUpload();
		
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		headers.add("User-Agent", "B2B_IW_PortalRestTemplate");
		headers.add("Authorization", "Basic " + authToken);
		HttpEntity<?> entity = new HttpEntity<>(clientSoftdataUpdateRequest, headers);
		
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(softdataUrl);
		ResponseEntity<ClientSoftdataUpdateResponse> result = 
				getRestTemplate().exchange(builder.toUriString(), HttpMethod.POST, entity, ClientSoftdataUpdateResponse.class);
		return result.getBody();
	}
	
	/**
	 * POST - ClientSoftdataUpload
	 * 
	 * @param softDataUpload
	 * @return
	 */
	public ConsignmentTracking getClientConsignmentTracking(String refNumber) {
		// Invoke Shipsy API
		String authToken = propertiesConfig.getShipsyApiAuthtoken();
		String consignmentTrackingUrl = propertiesConfig.getShipsyApiServer() + propertiesConfig.getShipsyApiConsignmentTracking();
		
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		headers.add("User-Agent", "B2B_IW_PortalRestTemplate");
		headers.add("Authorization", "Basic " + authToken);
		HttpEntity<?> entity = new HttpEntity<>(headers);
		
		// https://app.shipsy.in/api/client/integration/consignment/track?reference_number=E12345678"
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(consignmentTrackingUrl + "?reference_number=" + refNumber);
		ResponseEntity<ConsignmentTracking> result = getRestTemplate().exchange(builder.toUriString(), HttpMethod.GET, entity,
				ConsignmentTracking.class);
		return result.getBody();
	}

	/**
	 * 
	 * @param clientCancelOrderRequest
	 * @return
	 */
	public ClientCancelOrderResponse cancelOrder (@Valid ClientCancelOrderRequest clientCancelOrderRequest) {
		// Invoke Shipsy API
		String authToken = propertiesConfig.getShipsyApiAuthtoken();
		String cancelOrderUrl = propertiesConfig.getShipsyApiServer() + propertiesConfig.getShipsyApiOrderCancel();
		
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		headers.add("User-Agent", "B2B_IW_PortalRestTemplate");
		headers.add("Authorization", "Basic " + authToken);
		HttpEntity<?> entity = new HttpEntity<>(clientCancelOrderRequest, headers);
		
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(cancelOrderUrl);
		ResponseEntity<ClientCancelOrderResponse> result = getRestTemplate().exchange(builder.toUriString(), HttpMethod.GET, entity,
				ClientCancelOrderResponse.class);
		return result.getBody();
	}
	
	//---------------------------------Shipping Label-------------------------------------------------------------
	/**
	 * 
	 * @param refNumber
	 * @return
	 */
	public String getShippingLabel(String refNumber) {
		// Invoke Shipsy API
		try {
			String authToken = propertiesConfig.getShipsyApiAuthtoken();
			String consignmentTrackingUrl = propertiesConfig.getShipsyApiServer() + propertiesConfig.getShipsyApiLabelGen();
			RestTemplate restTemplate = getRestTemplate();
			HttpHeaders headers = new HttpHeaders();
			headers.add("User-Agent", "B2B_IW_PortalRestTemplate");
			headers.add("Authorization", "Basic " + authToken);
			HttpEntity<?> entity = new HttpEntity<>(headers);
			
			// https://demodashboardapi.shipsy.in/api/client/integration/consignment/shippinglabel/stream?reference_number=BLEND099
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(consignmentTrackingUrl + "?reference_number=" + refNumber);
			ResponseEntity<String> result = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, String.class);
			return result.getBody();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	// WEBHOOK
	public String listenWebhook(String referenceNumber) {
		// Invoke Shipsy API
		try {
			String authToken = propertiesConfig.getShipsyApiAuthtoken();
			String webhookUrl = propertiesConfig.getShipsyApiAsyadWebhook();
			
			HttpHeaders headers = new HttpHeaders();
			headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
			headers.add("User-Agent", "B2B_IW_PortalRestTemplate");
			headers.add("Authorization", "Basic " + authToken);
			HttpEntity<?> entity = new HttpEntity<>(headers);
			
			// 	https://apix.asyadexpress.com/v2/webhooks/incoming-integration?source=IW
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(webhookUrl + "?source=IW");
			ResponseEntity<String> result = getRestTemplate().exchange(builder.toUriString(), HttpMethod.GET, entity, String.class);
			return result.getBody();
		} catch (RestClientException e) {
			e.printStackTrace();
		}
		return referenceNumber;
	}

	public String postClientSoftdataUpload(SoftDataUpload dbSoftDataUpload) {
		return null;
	}
}
