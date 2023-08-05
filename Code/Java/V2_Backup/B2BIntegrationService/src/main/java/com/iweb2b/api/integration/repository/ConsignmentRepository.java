package com.iweb2b.api.integration.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.iweb2b.api.integration.model.consignment.entity.ConsignmentEntity;

@Repository
public interface ConsignmentRepository extends JpaRepository<ConsignmentEntity, Long> {

	public List<ConsignmentEntity> findAll();

	@Query(value = "SELECT * \r\n" +
			"FROM tblconsignment where reference_number in (:reference_number)", nativeQuery = true)
	public ConsignmentEntity findConsigment (@Param("reference_number") String reference_number);
	
	@Query(value = "SELECT REFERENCE_NUMBER FROM tblconsignment where reference_number like 'QAP%';", nativeQuery = true)
	public List<String> findConsigmentByQP();
	
	@Query(value = "SELECT REFERENCE_NUMBER FROM tblconsignment where AWB_3RD_PARTY=:jnt_billcode", nativeQuery = true)
	public String findConsigmentByBillCode(@Param("jnt_billcode") String jnt_billcode);

	//select tc.REFERENCE_NUMBER from tblconsignment tc join tblconsignmentwebhook tcw on tcw.REFERENCE_NUMBER = tc.REFERENCE_NUMBER WHERE tcw.hub_code = 'JT' GROUP BY tc.REFERENCE_NUMBER;
	@Query(value ="select tc.REFERENCE_NUMBER \n"+
			"from tblconsignment tc\n" +
			"join tblconsignmentwebhook tcw on tcw.REFERENCE_NUMBER = tc.REFERENCE_NUMBER \n" +
			"WHERE tcw.hub_code = :hubCode GROUP BY tc.REFERENCE_NUMBER",nativeQuery = true)
	public List<String> getByHubcode(@Param(value="hubCode") String hubCode);

	@Query(value = "SELECT TOP 1 * \r\n" +
			"FROM tBLCONSIGNMENT WHERE REFERENCE_NUMBER IN (:reference_number) ORDER BY CREATED_AT DESC", nativeQuery = true)
	public ConsignmentEntity findConsigmentUniqueRecord (@Param("reference_number") String reference_number);

	// SELECT TOP 1 jw.scan_type scanType FROM tbljntwebhook jw WHERE JW.BILL_CODE = 'JTE000145058765' ORDER BY SCAN_TIME DESC;
	@Query(value ="SELECT TOP 1 jw.scan_type scanType \r\n"
			+ "FROM tbljntwebhook jw WHERE JW.BILL_CODE = :billCode \r\n"
			+ "ORDER BY SCAN_TIME DESC", nativeQuery = true)
	public String getScanType(@Param(value="billCode") String billCode);
}

