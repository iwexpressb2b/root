package com.iweb2b.api.integration.model.softdataupload;

import lombok.Data;

@Data
public class ClientCancelOrderResponse {

	/*
	 * [
	 * 		{
				status: string
					failures: {
						reference_number: string
						message: string
						reason: string
						code: string
					}
				success: boolean
			}
		]
	 */
    private String status;
    private Features failures;
    private Boolean success;
}
