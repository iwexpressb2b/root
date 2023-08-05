package com.iweb2b.api.integration.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iweb2b.api.integration.model.softdataupload.SoftDataUpload;

@Repository
public interface SoftDataUploadRepository extends JpaRepository<SoftDataUpload, Long>{

    public List<SoftDataUpload> findAll();

//    public Optional<SoftDataUpload> findBySoftDataUploadIdAndDeletionIndicator(Long Id, long l);

}