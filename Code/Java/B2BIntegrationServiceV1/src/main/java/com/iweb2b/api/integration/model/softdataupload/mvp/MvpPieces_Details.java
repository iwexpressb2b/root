package com.iweb2b.api.integration.model.softdataupload.mvp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tblmvppiecesdetails")
public class MvpPieces_Details {
	
	/*
	 * 		{
               "description": "Sports Nutrition",
               "declared_value": 0,
               "weight": 2.63,
               "height": 18,
               "length": 11,
               "width": 13
          	}
	 */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PIECES_ID")
    private Long piecesId;
    @Column(name = "MVP_CONSIGNMENT_ID")
    private Long mvpConsignmentId;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "DECLARED_VALUE")
    private Double declared_value;
    @Column(name = "WEIGHT")
    private Double weight;
    @Column(name = "HEIGHT")
    private Double height;
    @Column(name = "LENGTH")
    private Long length;
    @Column(name = "WIDTH")
    private Long width;
    @Column(name = "IS_DELETED")
    private Long deletionIndicator = 0L;

    @Column(name = "CTD_BY")
    private String createdBy;

    @Column(name = "CTD_ON")
    private Date createdOn;

    @Column(name = "UTD_BY")
    private String updatedBy;

    @Column(name = "UTD_ON")
    private Date updatedOn;
}
