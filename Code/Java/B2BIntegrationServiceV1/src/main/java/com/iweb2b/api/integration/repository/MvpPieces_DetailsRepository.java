package com.iweb2b.api.integration.repository;

import com.iweb2b.api.integration.model.softdataupload.mvp.MvpOrigin_Details;
import com.iweb2b.api.integration.model.softdataupload.mvp.MvpPieces_Details;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MvpPieces_DetailsRepository extends JpaRepository<MvpPieces_Details, Long>{


}