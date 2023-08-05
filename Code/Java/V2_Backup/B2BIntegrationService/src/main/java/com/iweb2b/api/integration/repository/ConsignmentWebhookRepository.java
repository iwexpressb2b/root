package com.iweb2b.api.integration.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iweb2b.api.integration.model.consignment.entity.ConsignmentWebhookEntity;

@Repository
public interface ConsignmentWebhookRepository extends JpaRepository<ConsignmentWebhookEntity, Long> {
	List<ConsignmentWebhookEntity> findByType(String type);
}