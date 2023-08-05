package com.iweb2b.api.integration.model.softdataupload;

import java.util.Set;

import com.iweb2b.api.integration.model.Pieces_Details;

import lombok.Data;

@Data
public class ClientSoftdataUpdateRequest {

    private String reference_number;
    private String cod_amount;
    
//    @OneToMany(cascade = CascadeType.ALL,mappedBy = "id",fetch = FetchType.EAGER)
    private Set<Pieces_Details> Pdetails;
}
