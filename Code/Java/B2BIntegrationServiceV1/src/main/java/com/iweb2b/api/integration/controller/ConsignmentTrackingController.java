package com.iweb2b.api.integration.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iweb2b.api.integration.model.softdataupload.ClientCancelOrderRequest;
import com.iweb2b.api.integration.model.softdataupload.ClientCancelOrderResponse;
import com.iweb2b.api.integration.model.tracking.AddConsignmentTracking;
import com.iweb2b.api.integration.model.tracking.ConsignmentTracking;
import com.iweb2b.api.integration.model.tracking.UpdateConsignmentTracking;
import com.iweb2b.api.integration.service.ConsignmentTrackingService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Validated
@CrossOrigin(origins = "*")
@Api(tags = { "ConsignmentTracking" }, value = "ConsignmentTracking Operations related to ConsignmentTrackingController") // label for
																										// swagger
@SwaggerDefinition(tags = { @Tag(name = "ConsignmentTracking", description = "Operations related to ConsignmentTracking") })
@RequestMapping("/consignmentTracking")
@RestController
public class ConsignmentTrackingController {

	@Autowired
	ConsignmentTrackingService consignmentTrackingService;
	
	// To fetch shipment tracking for client
	@ApiOperation(response = ConsignmentTracking.class, value = "Get a ConsignmentTracking") // label for swagger
	@GetMapping("/{referenceNumber}/shipment")
	public ResponseEntity<?> getConsignmentTracking(@PathVariable String referenceNumber) {
		ConsignmentTracking dbConsignmentTracking = consignmentTrackingService.getConsignmentTracking(referenceNumber);
		log.info("ConsignmentTracking : " + dbConsignmentTracking);
		return new ResponseEntity<>(dbConsignmentTracking, HttpStatus.OK);
	}
		
	//------------------------------------------------------------------------------------------------------------------

	@ApiOperation(response = ConsignmentTracking.class, value = "Get all ConsignmentTracking details") // label for swagger
	@GetMapping("")
	public ResponseEntity<?> getAll() {
		List<ConsignmentTracking> consignmentTrackingList = consignmentTrackingService.getConsignmentTracking();
		return new ResponseEntity<>(consignmentTrackingList, HttpStatus.OK);
	}

	@ApiOperation(response = ConsignmentTracking.class, value = "Get a ConsignmentTracking") // label for swagger
	@GetMapping("/{id}")
	public ResponseEntity<?> getConsignmentTracking(@PathVariable Long id) {
		ConsignmentTracking dbConsignmentTracking = consignmentTrackingService.getConsignmentTracking(id);
		log.info("ConsignmentTracking : " + dbConsignmentTracking);
		return new ResponseEntity<>(dbConsignmentTracking, HttpStatus.OK);
	}
	
	@ApiOperation(response = ConsignmentTracking.class, value = "Create ConsignmentTracking") // label for swagger
	@PostMapping("")
	public ResponseEntity<?> postConsignmentTracking(@Valid @RequestBody AddConsignmentTracking newConsignmentTracking,
			@RequestParam String loginUserID) throws Exception {
		ConsignmentTracking createdConsignmentTracking = consignmentTrackingService.createConsignmentTracking(newConsignmentTracking, loginUserID);
		return new ResponseEntity<>(createdConsignmentTracking, HttpStatus.OK);
	}
	
	@ApiOperation(response = ConsignmentTracking.class, value = "Create ConsignmentTracking") // label for swagger
	@PostMapping("/cancelOrder")
	public ResponseEntity<?> postCancelOrder(@Valid @RequestBody ClientCancelOrderRequest clientCancelOrderRequest,
			@RequestParam String loginUserID) throws Exception {
		ClientCancelOrderResponse clientCancelOrderResponse = consignmentTrackingService.cancelOrder(clientCancelOrderRequest);
		return new ResponseEntity<>(clientCancelOrderResponse, HttpStatus.OK);
	}

	@ApiOperation(response = ConsignmentTracking.class, value = "Update ConsignmentTracking") // label for swagger
	@PatchMapping("/{id}")
	public ResponseEntity<?> patchConsignmentTracking(@PathVariable Long id,
			@RequestParam String loginUserID,
			@Valid @RequestBody UpdateConsignmentTracking updateConsignmentTracking)
			throws IllegalAccessException, InvocationTargetException {
		ConsignmentTracking updatedConsignmentTracking = consignmentTrackingService.updateConsignmentTracking(id, loginUserID,
				updateConsignmentTracking);
		return new ResponseEntity<>(updatedConsignmentTracking, HttpStatus.OK);
	}

	@ApiOperation(response = ConsignmentTracking.class, value = "Delete ConsignmentTracking") // label for swagger
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteConsignmentTracking(@PathVariable Long id, @RequestParam String loginUserID) {
		consignmentTrackingService.deleteConsignmentTracking(id, loginUserID);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
