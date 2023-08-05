package com.iweb2b.api.integration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iweb2b.api.integration.model.softdataupload.client.Consignment;

@Repository
public interface ConsignmentRepository extends JpaRepository<Consignment, Long>{
//	public interface ConsignmentRepository extends JpaRepository<MvpConsignment, Long>{

}