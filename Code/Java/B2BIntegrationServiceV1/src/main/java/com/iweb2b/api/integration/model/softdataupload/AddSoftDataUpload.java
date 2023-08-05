package com.iweb2b.api.integration.model.softdataupload;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.iweb2b.api.integration.model.AddDestinationDetail;
import com.iweb2b.api.integration.model.AddOriginDetail;
import com.iweb2b.api.integration.model.AddPiecesDetail;

import lombok.Data;

@Data
public class AddSoftDataUpload {

    private String action_type;
    private String consignment_type;
    private String movement_type;
    private String eway_bill;
    private String load_type;
    private String description;
    private String customer_code;
    private String reference_number;
    private String service_type_id;
    private String cod_favor_of;
    private String cod_collection_mode;
    private String dimension_unit;
    private String length;
    private String width;
    private String height;
    private String weight_unit;
    private String volume;
    private String volume_unit;
    private String weight;
    private String cod_amount;
    private String invoice_amount;
    private String invoice_number;
    private String invoice_date;
    private String declared_value;
    private String declared_value_without_tax;
    private String product_code;
    private String num_pieces;
    private String customer_reference_number;
    private String is_risk_surcharge_applicable;
    private String courier_partner;
    private String courier_account;
    private String courier_partner_reference_number;
    private String hub_code;
    private String hsn_code;

    private String reporting_branch_code;
    private String manifest_number;
    private String manifest_time;
    private String auto_accept;
    private String constraint_tag;
    private String worker_code;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "softDataUploadId",fetch = FetchType.EAGER)
    private Set<AddTaxDetail> taxDetail;

    private String delivery_time_slot_start;
    private String delivery_time_slot_end;
    private String scheduled_at;
    private Date service_time;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "softDataUploadId",fetch = FetchType.EAGER)
    private Set<AddOriginDetail> originDetail;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "softDataUploadId",fetch = FetchType.EAGER)
    private Set<AddDestinationDetail> destinationDetail;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "softDataUploadId",fetch = FetchType.EAGER)
    private Set<AddNode> nodes;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "softDataUploadId",fetch = FetchType.EAGER)
    private Set<AddReturnDetail> returnDetail;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "softDataUploadId",fetch = FetchType.EAGER)
    private Set<AddPiecesDetail> piecesDetail;

    private Long deletionIndicator;
    private String referenceField1;
    private String referenceField2;
    private String referenceField3;
    private String referenceField4;
    private String referenceField5;
    private String referenceField6;
    private String referenceField7;
    private String referenceField8;
    private String referenceField9;
    private String referenceField10;
    private String createdBy;
}
