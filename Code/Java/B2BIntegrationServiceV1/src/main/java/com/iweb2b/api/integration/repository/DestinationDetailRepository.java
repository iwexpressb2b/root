package com.iweb2b.api.integration.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iweb2b.api.integration.model.DestinationDetail;

@Repository
public interface DestinationDetailRepository extends JpaRepository<DestinationDetail, Long>{

    public List<DestinationDetail> findAll();

//    public Optional<DestinationDetail> findByIdAndDeletionIndicator(Long Id, long l);
}