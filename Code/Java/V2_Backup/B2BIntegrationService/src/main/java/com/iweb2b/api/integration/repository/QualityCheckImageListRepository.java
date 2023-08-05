package com.iweb2b.api.integration.repository;

import com.iweb2b.api.integration.model.consignment.entity.QualityCheckImageListEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QualityCheckImageListRepository extends JpaRepository<QualityCheckImageListEntity, Long> {

}