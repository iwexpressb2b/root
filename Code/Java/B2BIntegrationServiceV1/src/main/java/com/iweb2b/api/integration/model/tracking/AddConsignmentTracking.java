package com.iweb2b.api.integration.model.tracking;

import com.iweb2b.api.integration.model.*;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.Set;

@Data
public class AddConsignmentTracking {

    private String reference_number;

    private String service_type_id;

    private String courier_partner_reference_number;

    private String courier_partner;

    private String courier_account;

    private String attempt_count;

    private String status;

    private String delivery_kyc_type;

    private String delivery_kyc_number;

    private Boolean is_cod;

    private String cod_amount;

    private String hub_code;

    private String creation_date;

    private String weight;

    private String receiver_name;

    private String num_pieces;

    private String customer_code;

    private String customer_name;

    private String billing_type;

    private String origin_location_code;

    private String destination_location_code;

    private String drs_number;

    private String pickup_attempt_count;

    private String carrier_payment_details;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "consignmentTrackingId",fetch = FetchType.EAGER)
    private Set<AddPiecesDetail> pdetails;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "consignmentTrackingId",fetch = FetchType.EAGER)
    private Set<AddOriginDetail> odetails;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "consignmentTrackingId",fetch = FetchType.EAGER)
    private Set<AddDestinationDetail> ddetails;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "consignmentTrackingId",fetch = FetchType.EAGER)
    private Set<AddEvent> events;

    private Long deletionIndicator = 0L;

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

    private Date createdOn;

    private String updatedBy;

    private Date updatedOn;
}
