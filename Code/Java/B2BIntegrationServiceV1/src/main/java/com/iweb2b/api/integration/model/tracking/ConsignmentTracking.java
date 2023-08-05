package com.iweb2b.api.integration.model.tracking;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.iweb2b.api.integration.model.DestinationDetail;
import com.iweb2b.api.integration.model.OriginDetail;
import com.iweb2b.api.integration.model.PiecesDetail;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tblconsignmenttracking")
public class ConsignmentTracking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(name="CONSIGNMENT_TRACKING_ID")
	private Long consignmentTrackingId;

	@Column(name="REFERENCE_NUMBER")
	private String reference_number;
	
	@Column(name="SERVICE_TYPE_ID")
	private String service_type_id;
	
	@Column(name="COURIER_PARTNER_REFERENCE_NUMBER")
	private String courier_partner_reference_number;
	
	@Column(name="COURIER_PARTNER")
	private String courier_partner;
	
	@Column(name="COURIER_ACCOUNT")
	private String courier_account;
	
	@Column(name="ATTEMPT_COUNT")
	private String attempt_count;
	
	@Column(name="STATUS")
	private String status;
	
	@Column(name="DELIVERY_KYC_TYPE")
	private String delivery_kyc_type;
	
	@Column(name="DELIVERY_KYC_NUMBER")
	private String delivery_kyc_number;
	
	@Column(name="IS_COD")
	private Boolean is_cod;
	
	@Column(name="COD_AMOUNT")
	private String cod_amount;
	
	@Column(name="HUB_CODE")
	private String hub_code;
	
	@Column(name="CREATION_DATE")
	private String creation_date;
	
	@Column(name="WEIGHT")
	private String weight;
	
	@Column(name="RECEIVER_NAME")
	private String receiver_name;
	
	@Column(name="NUM_PIECES")
	private String num_pieces;
	
	@Column(name="CUSTOMER_CODE")
	private String customer_code;
	
	@Column(name="CUSTOMER_NAME")
	private String customer_name;
	
	@Column(name="BILLING_TYPE")
	private String billing_type;
	
	@Column(name="ORIGIN_LOCATION_CODE")
	private String origin_location_code;
	
	@Column(name="DESTINATION_LOCATION_CODE")
	private String destination_location_code;
	
	@Column(name="DRS_NUMBER")
	private String drs_number;
	
	@Column(name="PICKUP_ATTEMPT_COUNT")
	private String pickup_attempt_count;
	
	@Column(name="CARRIER_PAYMENT_DETAILS")
	private String carrier_payment_details;

	@OneToMany(cascade = CascadeType.ALL,mappedBy = "consignmentTrackingId",fetch = FetchType.EAGER)
	private Set<PiecesDetail> pieces_detail;

	@OneToMany(cascade = CascadeType.ALL,mappedBy = "consignmentTrackingId",fetch = FetchType.EAGER)
	private Set<OriginDetail> origin_details;

	@OneToMany(cascade = CascadeType.ALL,mappedBy = "consignmentTrackingId",fetch = FetchType.EAGER)
	private Set<DestinationDetail> destination_details;

	@OneToMany(cascade = CascadeType.ALL,mappedBy = "consignmentTrackingId",fetch = FetchType.EAGER)
	private Set<Event> events;
}
