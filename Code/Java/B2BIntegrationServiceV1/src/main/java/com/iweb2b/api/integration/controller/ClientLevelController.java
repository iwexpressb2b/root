//package com.iweb2b.api.integration.controller;
//
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.iweb2b.api.integration.service.IntegrationService;
//
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import io.swagger.annotations.SwaggerDefinition;
//import io.swagger.annotations.Tag;
//import lombok.extern.slf4j.Slf4j;
//
//@Slf4j
//@Validated
//@CrossOrigin(origins = "*")
//@Api(tags = { "ClientLevel" }, value = "ClientLevel Operations related to ClientLevelController") // label for
//																										// swagger
//@SwaggerDefinition(tags = { @Tag(name = "ClientLevel", description = "Operations related to ClientLevel") })
//@RequestMapping("/clientLevel")
//@RestController
//public class ClientLevelController {
//
//	@Autowired
//	IntegrationService integrationService;
//	
//	//--------------------------------------Shipping (AWB) label-----------------------------------------------------------------------
//	@ApiOperation(response = Optional.class, value = "Get a ClientLevel") // label for swagger
//	@GetMapping("/{referenceNumber}/shippingLabel")
//	public ResponseEntity<?> getShippingLabel(@PathVariable String referenceNumber) {
//		byte[] dbClientLevel = integrationService.getShippingLabel(referenceNumber);
//		log.info("ClientLevel : " + dbClientLevel);
//		return new ResponseEntity<>(dbClientLevel, HttpStatus.OK);
//	}
//	
//	//--------------------------------------ASD Webhook Endpoint-----------------------------------------------------------------------
//	@ApiOperation(response = Optional.class, value = "Get Asyad Webhook") // label for swagger
//	@GetMapping("/{referenceNumber}/webhook")
//	public ResponseEntity<?> listenWebhook(@PathVariable String referenceNumber) {
//		String webhookResponse = integrationService.listenWebhook(referenceNumber);
//		log.info("webhookResponse : " + webhookResponse);
//		return new ResponseEntity<>(webhookResponse, HttpStatus.OK);
//	}
//}
