package com.iweb2b.api.integration.repository;

import com.iweb2b.api.integration.model.softdataupload.mvp.MvpDestination_Details;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MvpDestination_DetailsRepository extends JpaRepository<MvpDestination_Details, Long>{


}