package com.iweb2b.api.integration.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iweb2b.api.integration.model.softdataupload.ReturnDetail;

@Repository
public interface ReturnDetailRepository extends JpaRepository<ReturnDetail, Long>{

    public List<ReturnDetail> findAll();

//    public Optional<ReturnDetail> findByIdAndDeletionIndicator(Long Id, long l);
}