package com.iweb2b.api.integration.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iweb2b.api.integration.model.softdataupload.TaxDetail;

@Repository
public interface TaxDetailRepository extends JpaRepository<TaxDetail, Long>{

    public List<TaxDetail> findAll();

//    public Optional<TaxDetail> findByIdAndDeletionIndicator(Long Id, long l);
}