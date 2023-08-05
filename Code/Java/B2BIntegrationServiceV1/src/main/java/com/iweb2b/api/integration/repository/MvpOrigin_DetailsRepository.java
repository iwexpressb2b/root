package com.iweb2b.api.integration.repository;

import com.iweb2b.api.integration.model.softdataupload.mvp.MvpOrigin_Details;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MvpOrigin_DetailsRepository extends JpaRepository<MvpOrigin_Details, Long>{


}