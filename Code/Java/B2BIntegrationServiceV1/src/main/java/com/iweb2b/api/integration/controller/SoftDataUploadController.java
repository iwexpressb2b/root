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

import com.iweb2b.api.integration.model.softdataupload.ClientSoftdataUpdateRequest;
import com.iweb2b.api.integration.model.softdataupload.ClientSoftdataUpdateResponse;
import com.iweb2b.api.integration.model.softdataupload.SoftDataUpload;
import com.iweb2b.api.integration.model.softdataupload.client.Consignment;
import com.iweb2b.api.integration.model.softdataupload.client.ConsignmentResponse;
import com.iweb2b.api.integration.service.SoftDataUploadService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Validated
@CrossOrigin(origins = "*")
@Api(tags = { "SoftDataUpload" }, value = "SoftDataUpload Operations related to SoftDataUploadController") // label for
																										// swagger
@SwaggerDefinition(tags = { @Tag(name = "SoftDataUpload", description = "Operations related to SoftDataUpload") })
@RequestMapping("/softDataUpload")
@RestController
public class SoftDataUploadController {

	@Autowired
	SoftDataUploadService softDataUploadService;

	@ApiOperation(response = SoftDataUpload.class, value = "Get all SoftDataUpload details") // label for swagger
	@GetMapping("")
	public ResponseEntity<?> getAll() {
		List<SoftDataUpload> softDataUploadList = softDataUploadService.getSoftDataUpload();
		return new ResponseEntity<>(softDataUploadList, HttpStatus.OK);
	}

	@ApiOperation(response = SoftDataUpload.class, value = "Get a SoftDataUpload") // label for swagger
	@GetMapping("/{id}")
	public ResponseEntity<?> getSoftDataUpload(@PathVariable Long id) {
		SoftDataUpload dbSoftDataUpload = softDataUploadService.getSoftDataUpload(id);
		log.info("SoftDataUpload : " + dbSoftDataUpload);
		return new ResponseEntity<>(dbSoftDataUpload, HttpStatus.OK);
	}

//	@ApiOperation(response = SoftDataUpload.class, value = "Create SoftDataUpload") // label for swagger
//	@PostMapping("")
//	public ResponseEntity<?> postSoftDataUpload(@Valid @RequestBody AddSoftDataUpload newSoftDataUpload,
//			@RequestParam String loginUserID) throws Exception {
//		SoftDataUpload createdSoftDataUpload = softDataUploadService.createSoftDataUpload(newSoftDataUpload, loginUserID);
//		return new ResponseEntity<>(createdSoftDataUpload, HttpStatus.OK);
//	}
	
	/*
	 * Asyad
	 */
	@ApiOperation(response = Consignment.class, value = "Create Consignment") // label for swagger
	@PostMapping("/asyad")
	public ResponseEntity<?> postConsignment(@Valid @RequestBody Consignment newConsignment,
			@RequestParam String loginUserID) throws Exception {
		ConsignmentResponse response = softDataUploadService.createConsignment(newConsignment, loginUserID);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@ApiOperation(response = SoftDataUpload.class, value = "Update SoftDataUpload") // label for swagger
	@PatchMapping("")
	public ResponseEntity<?> patchSoftDataUpload(@Valid @RequestBody ClientSoftdataUpdateRequest clientSoftdataUpdateRequest)
			throws IllegalAccessException, InvocationTargetException {
		ClientSoftdataUpdateResponse updatedSoftDataUpload = softDataUploadService.updateSoftDataUpload(clientSoftdataUpdateRequest);
		return new ResponseEntity<>(updatedSoftDataUpload, HttpStatus.OK);
	}

	@ApiOperation(response = SoftDataUpload.class, value = "Delete SoftDataUpload") // label for swagger
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteSoftDataUpload(@PathVariable Long id, @RequestParam String loginUserID) {
		softDataUploadService.deleteSoftDataUpload(id, loginUserID);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
