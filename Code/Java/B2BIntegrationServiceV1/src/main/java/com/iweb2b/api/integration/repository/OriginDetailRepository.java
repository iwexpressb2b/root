package com.iweb2b.api.integration.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iweb2b.api.integration.model.OriginDetail;

@Repository
public interface OriginDetailRepository extends JpaRepository<OriginDetail, Long>{

    public List<OriginDetail> findAll();

//    public Optional<OriginDetail> findByIdAndDeletionIndicator(Long Id, long l);
}