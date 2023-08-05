package com.iweb2b.api.integration.model.softdataupload;

import lombok.Data;

@Data
public class ClientSoftdataUpdateResponse {

	/*
	 * {
			"status": "OK",
			"success": true,
			"reference_number": "E12345678"
		}
	 */
    private String status;
    private Boolean success;
    private String reference_number;
}
