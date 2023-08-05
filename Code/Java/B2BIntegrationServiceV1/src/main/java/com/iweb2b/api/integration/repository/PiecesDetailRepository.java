package com.iweb2b.api.integration.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iweb2b.api.integration.model.PiecesDetail;

@Repository
public interface PiecesDetailRepository extends JpaRepository<PiecesDetail, Long>{

    public List<PiecesDetail> findAll();

//    public Optional<PiecesDetail> findByIdAndDeletionIndicator(Long Id, long l);
}