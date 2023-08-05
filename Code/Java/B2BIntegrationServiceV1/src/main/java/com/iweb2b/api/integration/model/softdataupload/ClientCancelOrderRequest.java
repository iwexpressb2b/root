package com.iweb2b.api.integration.model.softdataupload;

import java.util.List;

import lombok.Data;

@Data
public class ClientCancelOrderRequest {

	/*
	 * AWBNo: [string] - Reference Number List
	 * customerCode: string
	 */
    private List<String> AWBNo;
    private String customerCode;
}
