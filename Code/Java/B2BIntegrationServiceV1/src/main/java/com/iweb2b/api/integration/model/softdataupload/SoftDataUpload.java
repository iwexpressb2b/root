package com.iweb2b.api.integration.model.softdataupload;

import java.util.Date;
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
@Table(name = "tblsoftdataupload")
public class SoftDataUpload {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SOFT_DATA_UPLOAD_ID")
	private Long softDataUploadId;

	@Column(name="ACTION_TYPE")
	private String action_type;
	
	@Column(name="CONSIGNMENT_TYPE")
	private String consignment_type;
	
	@Column(name="MOVEMENT_TYPE")
	private String movement_type;
	
	@Column(name="EWAY_BILL")
	private String eway_bill;
	
	@Column(name="LOAD_TYPE")
	private String load_type;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@Column(name="CUSTOMER_CODE")
	private String customer_code;
	
	@Column(name="REFERENCE_NUMBER")
	private String reference_number;
	
	@Column(name="SERVICE_TYPE_ID")
	private String service_type_id;
	
	@Column(name="COD_FAVOR_OF")
	private String cod_favor_of;
	
	@Column(name="COD_COLLECTION_MODE")
	private String cod_collection_mode;
	
	@Column(name="DIMENSION_UNIT")
	private String dimension_unit;
	
	@Column(name="LENGTH")
	private String length;
	
	@Column(name="WIDTH")
	private String width;
	
	@Column(name="HEIGHT")
	private String height;
	
	@Column(name="WEIGHT_UNIT")
	private String weight_unit;
	
	@Column(name="VOLUME")
	private String volume;
	
	@Column(name="VOLUME_UNIT")
	private String volume_unit;
	
	@Column(name="WEIGHT")
	private String weight;
	
	@Column(name="COD_AMOUNT")
	private String cod_amount;
	
	@Column(name="INVOICE_AMOUNT")
	private String invoice_amount;
	
	@Column(name="INVOICE_NUMBER")
	private String invoice_number;
	
	@Column(name="INVOICE_DATE")
	private String invoice_date;
	
	@Column(name="DECLARED_VALUE")
	private String declared_value;
	
	@Column(name="DECLARED_VALUE_WITHOUT_TAX")
	private String declared_value_without_tax;
	
	@Column(name="PRODUCT_CODE")
	private String product_code;
	
	@Column(name="NUM_PIECES")
	private String num_pieces;
	
	@Column(name="CUSTOMER_REFERENCE_NUMBER")
	private String customer_reference_number;
	
	@Column(name="IS_RISK_SURCHARGE_APPLICABLE")
	private String is_risk_surcharge_applicable;
	
	@Column(name="COURIER_PARTNER")
	private String courier_partner;
	
	@Column(name="COURIER_ACCOUNT")
	private String courier_account;
	
	@Column(name="COURIER_PARTNER_REFERENCE_NUMBER")
	private String courier_partner_reference_number;
	
	@Column(name="HUB_CODE")
	private String hub_code;
	
	@Column(name="HSN_CODE")
	private String hsn_code;


	@Column(name="REPORTING_BRANCH_CODE")
	private String reporting_branch_code;

	@Column(name="MANIFEST_NUMBER")
	private String manifest_number;

	@Column(name="MANIFEST_TIME")
	private String manifest_time;

	@Column(name="AUTO_ACCEPT")
	private String auto_accept;

	@Column(name="CONSTRAINT_TAG")
	private String constraint_tag;

	@Column(name="WORKER_CODE")
	private String worker_code;


	@OneToMany(cascade = CascadeType.ALL,mappedBy = "softDataUploadId",fetch = FetchType.EAGER)
	private Set<TaxDetail> tdetails;

	@Column(name="DELIVERY_TIME_SLOT_START")
	private String delivery_time_slot_start;
	
	@Column(name="DELIVERY_TIME_SLOT_END")
	private String delivery_time_slot_end;
	
	@Column(name="SCHEDULED_AT")
	private String scheduled_at;
	
	@Column(name="SERVICE_TIME")
	private Date service_time;

	@OneToMany(cascade = CascadeType.ALL,mappedBy = "softDataUploadId",fetch = FetchType.EAGER)
	private Set<OriginDetail> odetails;

	@OneToMany(cascade = CascadeType.ALL,mappedBy = "softDataUploadId",fetch = FetchType.EAGER)
	private Set<DestinationDetail> ddetails;
	
//	@OneToOne(cascade = CascadeType.ALL,mappedBy = "softDataUploadId",fetch = FetchType.EAGER)
//	private OriginDetail odetails;
//
//	@OneToOne(cascade = CascadeType.ALL,mappedBy = "softDataUploadId",fetch = FetchType.EAGER)
//	private DestinationDetail ddetails;

	@OneToMany(cascade = CascadeType.ALL,mappedBy = "softDataUploadId",fetch = FetchType.EAGER)
	private Set<Node> nodes;

	@OneToMany(cascade = CascadeType.ALL,mappedBy = "softDataUploadId",fetch = FetchType.EAGER)
	private Set<ReturnDetail> rdetails;

	@OneToMany(cascade = CascadeType.ALL,mappedBy = "softDataUploadId",fetch = FetchType.EAGER)
	private Set<PiecesDetail> pdetails;

	@Column(name = "IS_DELETED")
	private Long deletionIndicator = 0L;

	@Column(name = "REF_FIELD_1")
	private String referenceField1;

	@Column(name = "REF_FIELD_2")
	private String referenceField2;

	@Column(name = "REF_FIELD_3")
	private String referenceField3;

	@Column(name = "REF_FIELD_4")
	private String referenceField4;

	@Column(name = "REF_FIELD_5")
	private String referenceField5;

	@Column(name = "REF_FIELD_6")
	private String referenceField6;

	@Column(name = "REF_FIELD_7")
	private String referenceField7;

	@Column(name = "REF_FIELD_8")
	private String referenceField8;

	@Column(name = "REF_FIELD_9")
	private String referenceField9;

	@Column(name = "REF_FIELD_10")
	private String referenceField10;

	@Column(name = "CTD_BY")
	private String createdBy;

	@Column(name = "CTD_ON")
	private Date createdOn;

	@Column(name = "UTD_BY")
	private String updatedBy;

	@Column(name = "UTD_ON")
	private Date updatedOn;
}