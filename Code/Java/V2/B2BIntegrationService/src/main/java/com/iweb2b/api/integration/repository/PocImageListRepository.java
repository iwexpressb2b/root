package com.iweb2b.api.integration.repository;

import com.iweb2b.api.integration.model.consignment.entity.PocImageListEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PocImageListRepository extends JpaRepository<PocImageListEntity, Long> {

}