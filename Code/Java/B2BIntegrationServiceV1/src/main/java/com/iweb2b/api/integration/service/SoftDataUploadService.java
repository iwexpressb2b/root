package com.iweb2b.api.integration.service;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iweb2b.api.integration.config.PropertiesConfig;
import com.iweb2b.api.integration.model.DestinationDetail;
import com.iweb2b.api.integration.model.OriginDetail;
import com.iweb2b.api.integration.model.PiecesDetail;
import com.iweb2b.api.integration.model.UpdateDestinationDetail;
import com.iweb2b.api.integration.model.UpdateOriginDetail;
import com.iweb2b.api.integration.model.UpdatePiecesDetail;
import com.iweb2b.api.integration.model.softdataupload.AddSoftDataUpload;
import com.iweb2b.api.integration.model.softdataupload.ClientSoftdataUpdateRequest;
import com.iweb2b.api.integration.model.softdataupload.ClientSoftdataUpdateResponse;
import com.iweb2b.api.integration.model.softdataupload.Node;
import com.iweb2b.api.integration.model.softdataupload.ReturnDetail;
import com.iweb2b.api.integration.model.softdataupload.SoftDataUpload;
import com.iweb2b.api.integration.model.softdataupload.TaxDetail;
import com.iweb2b.api.integration.model.softdataupload.UpdateNode;
import com.iweb2b.api.integration.model.softdataupload.UpdateReturnDetail;
import com.iweb2b.api.integration.model.softdataupload.UpdateSoftDataUpload;
import com.iweb2b.api.integration.model.softdataupload.UpdateTaxDetail;
import com.iweb2b.api.integration.model.softdataupload.client.Consignment;
import com.iweb2b.api.integration.model.softdataupload.client.ConsignmentResponse;
import com.iweb2b.api.integration.repository.ConsignmentRepository;
import com.iweb2b.api.integration.repository.DestinationDetailRepository;
import com.iweb2b.api.integration.repository.NodeRepository;
import com.iweb2b.api.integration.repository.OriginDetailRepository;
import com.iweb2b.api.integration.repository.PiecesDetailRepository;
import com.iweb2b.api.integration.repository.ReturnDetailRepository;
import com.iweb2b.api.integration.repository.SoftDataUploadRepository;
import com.iweb2b.api.integration.repository.TaxDetailRepository;
import com.iweb2b.api.integration.util.CommonUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SoftDataUploadService {
	
	@Autowired
	PropertiesConfig propertiesConfig;

	@Autowired
	IntegrationService integrationService;
	
	@Autowired
	private SoftDataUploadRepository softDataUploadRepository;
	
	@Autowired
	private ConsignmentRepository consignmentRepository;

	@Autowired
	private PiecesDetailRepository piecesDetailRepository;

	@Autowired
	private DestinationDetailRepository destinationDetailRepository;

	@Autowired
	private OriginDetailRepository originDetailRepository;

	@Autowired
	private TaxDetailRepository taxDetailRepository;

	@Autowired
	private ReturnDetailRepository returnDetailRepository;

	@Autowired
	private NodeRepository nodeRepository;

	@Autowired
	private DestinationDetailService destinationDetailService;

	@Autowired
	private PiecesDetailService piecesDetailService;

	@Autowired
	private OriginDetailService originDetailService;

	@Autowired
	private TaxDetailService taxDetailService;

	@Autowired
	private ReturnDetailService returnDetailService;

	@Autowired
	private NodeService nodeService;

	public List<SoftDataUpload> getSoftDataUpload () {
		List<SoftDataUpload> softDataUploadList =  softDataUploadRepository.findAll();
		softDataUploadList = softDataUploadList.stream().filter(n -> n.getDeletionIndicator() == 0).collect(Collectors.toList());
		return softDataUploadList;
	}

	/**
	 * getSoftDataUpload
	 * @param id
	 * @return
	 */
	public SoftDataUpload getSoftDataUpload (Long id) {
//		Optional<SoftDataUpload> softDataUpload = softDataUploadRepository.findBySoftDataUploadIdAndDeletionIndicator(id, 0L);
//		if (softDataUpload.isEmpty()) {
//			return null;
//		}
//		return softDataUpload.get();
		return null;
	}

	/**
	 * createSoftDataUpload
	 * @param newSoftDataUpload
	 * @return
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	public SoftDataUpload createSoftDataUpload (AddSoftDataUpload newSoftDataUpload, String loginUserId)
			throws IllegalAccessException, InvocationTargetException, Exception {
		try {
			SoftDataUpload dbSoftDataUpload = new SoftDataUpload();
			BeanUtils.copyProperties(newSoftDataUpload, dbSoftDataUpload, CommonUtils.getNullPropertyNames(newSoftDataUpload));
			dbSoftDataUpload.setDeletionIndicator(0L);
			dbSoftDataUpload.setCreatedBy(loginUserId);
			dbSoftDataUpload.setUpdatedBy(loginUserId);
			dbSoftDataUpload.setCreatedOn(new Date());
			dbSoftDataUpload.setUpdatedOn(new Date());
			
			// Call Shipsy API
			String response = integrationService.postClientSoftdataUpload (dbSoftDataUpload);
			if (response != null) {
				return softDataUploadRepository.save(dbSoftDataUpload);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	// POST - Asyad
	public ConsignmentResponse createConsignment (Consignment newConsignment, String loginUserId)
			throws IllegalAccessException, InvocationTargetException, Exception {
		try {
//			SoftDataUpload dbSoftDataUpload = new SoftDataUpload();
//			BeanUtils.copyProperties(newConsignment, dbSoftDataUpload, CommonUtils.getNullPropertyNames(newConsignment));
//			dbSoftDataUpload.setDeletionIndicator(0L);
//			dbSoftDataUpload.setCreatedBy(loginUserId);
//			dbSoftDataUpload.setUpdatedBy(loginUserId);
//			dbSoftDataUpload.setCreatedOn(new Date());
//			dbSoftDataUpload.setUpdatedOn(new Date());
			
			// Call Shipsy API
			ConsignmentResponse response = integrationService.postClientSoftdataUpload (newConsignment);
			log.info("Shipsy Response : " + response);
			if (response != null) {
				Consignment createdConsignment = consignmentRepository.save(newConsignment);
				log.info("createdConsignment in B2B DB: " + createdConsignment);
				return response;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return null;
	}
	
	/**
	 * 
	 * @param clientSoftdataUpdateRequest
	 * @return
	 */
	public ClientSoftdataUpdateResponse updateSoftDataUpload(@Valid ClientSoftdataUpdateRequest clientSoftdataUpdateRequest) {
		ClientSoftdataUpdateResponse response = integrationService.postClientSoftdataUpdate(clientSoftdataUpdateRequest);
		return response;
	}
//		SoftDataUpload dbSoftDataUpload = new SoftDataUpload();
//		BeanUtils.copyProperties(newSoftDataUpload, dbSoftDataUpload, CommonUtils.getNullPropertyNames(newSoftDataUpload));
//		dbSoftDataUpload.setDeletionIndicator(0L);
//		dbSoftDataUpload.setCreatedBy(loginUserId);
//		dbSoftDataUpload.setUpdatedBy(loginUserId);
//		dbSoftDataUpload.setCreatedOn(new Date());
//		dbSoftDataUpload.setUpdatedOn(new Date());
//		//	return softDataUploadRepository.save(dbSoftDataUpload);
//
//		SoftDataUpload savedSoftDataUpload = softDataUploadRepository.save(dbSoftDataUpload);
//
//		savedSoftDataUpload.setPdetails(new HashSet<>());
//		savedSoftDataUpload.setDdetails(new HashSet<>());
//		savedSoftDataUpload.setOdetails(new HashSet<>());
//		savedSoftDataUpload.setNodes(new HashSet<>());
//		savedSoftDataUpload.setTdetails(new HashSet<>());
//		savedSoftDataUpload.setRdetails(new HashSet<>());
//
//		for (AddPiecesDetail pdetail : newSoftDataUpload.getPdetails()) {
//			PiecesDetail dbPiecesDetail = new PiecesDetail();
//			BeanUtils.copyProperties(pdetail, dbPiecesDetail, CommonUtils.getNullPropertyNames(pdetail));
//			dbPiecesDetail.setDeletionIndicator(0L);
//			dbPiecesDetail.setCreatedBy(loginUserId);
//			dbPiecesDetail.setUpdatedBy(loginUserId);
//			dbPiecesDetail.setCreatedOn(new Date());
//			dbPiecesDetail.setUpdatedOn(new Date());
//			dbPiecesDetail.setSoftDataUploadId(savedSoftDataUpload.getSoftDataUploadId());
//			savedSoftDataUpload.getPdetails().add(piecesDetailRepository.save(dbPiecesDetail));
//		}
//		for (AddDestinationDetail ddetail : newSoftDataUpload.getDdetails()){
//			DestinationDetail dbDestinationDetail = new DestinationDetail();
//			BeanUtils.copyProperties(ddetail, dbDestinationDetail, CommonUtils.getNullPropertyNames(ddetail));
//			dbDestinationDetail.setDeletionIndicator(0L);
//			dbDestinationDetail.setCreatedBy(loginUserId);
//			dbDestinationDetail.setUpdatedBy(loginUserId);
//			dbDestinationDetail.setCreatedOn(new Date());
//			dbDestinationDetail.setUpdatedOn(new Date());
//			dbDestinationDetail.setSoftDataUploadId(savedSoftDataUpload.getSoftDataUploadId());
//			savedSoftDataUpload.getDdetails().add(destinationDetailRepository.save(dbDestinationDetail));
//		}
//		for (AddOriginDetail odetail : newSoftDataUpload.getOdetails()){
//			OriginDetail dbOriginDetail = new OriginDetail();
//			BeanUtils.copyProperties(odetail, dbOriginDetail, CommonUtils.getNullPropertyNames(odetail));
//			dbOriginDetail.setDeletionIndicator(0L);
//			dbOriginDetail.setCreatedBy(loginUserId);
//			dbOriginDetail.setUpdatedBy(loginUserId);
//			dbOriginDetail.setCreatedOn(new Date());
//			dbOriginDetail.setUpdatedOn(new Date());
//			dbOriginDetail.setSoftDataUploadId(savedSoftDataUpload.getSoftDataUploadId());
//			savedSoftDataUpload.getOdetails().add(originDetailRepository.save(dbOriginDetail));
//		}
//		for (AddTaxDetail tdetail : newSoftDataUpload.getTdetails()){
//			TaxDetail dbTaxDetail = new TaxDetail();
//			BeanUtils.copyProperties(tdetail, dbTaxDetail, CommonUtils.getNullPropertyNames(tdetail));
//			dbTaxDetail.setDeletionIndicator(0L);
//			dbTaxDetail.setCreatedBy(loginUserId);
//			dbTaxDetail.setUpdatedBy(loginUserId);
//			dbTaxDetail.setCreatedOn(new Date());
//			dbTaxDetail.setUpdatedOn(new Date());
//			dbTaxDetail.setSoftDataUploadId(savedSoftDataUpload.getSoftDataUploadId());
//			savedSoftDataUpload.getTdetails().add(taxDetailRepository.save(dbTaxDetail));
//		}
//		for (AddReturnDetail rdetail : newSoftDataUpload.getRdetails()){
//			ReturnDetail dbReturnDetail = new ReturnDetail();
//			BeanUtils.copyProperties(rdetail, dbReturnDetail, CommonUtils.getNullPropertyNames(rdetail));
//			dbReturnDetail.setDeletionIndicator(0L);
//			dbReturnDetail.setCreatedBy(loginUserId);
//			dbReturnDetail.setUpdatedBy(loginUserId);
//			dbReturnDetail.setCreatedOn(new Date());
//			dbReturnDetail.setUpdatedOn(new Date());
//			dbReturnDetail.setSoftDataUploadId(savedSoftDataUpload.getSoftDataUploadId());
//			savedSoftDataUpload.getRdetails().add(returnDetailRepository.save(dbReturnDetail));
//		}
//		for (AddNode node : newSoftDataUpload.getNodes()){
//			Node dbNode = new Node();
//			BeanUtils.copyProperties(node, dbNode, CommonUtils.getNullPropertyNames(node));
//			dbNode.setDeletionIndicator(0L);
//			dbNode.setCreatedBy(loginUserId);
//			dbNode.setUpdatedBy(loginUserId);
//			dbNode.setCreatedOn(new Date());
//			dbNode.setUpdatedOn(new Date());
//			dbNode.setSoftDataUploadId(savedSoftDataUpload.getSoftDataUploadId());
//			savedSoftDataUpload.getNodes().add(nodeRepository.save(dbNode));
//		}
//		return savedSoftDataUpload;
//	}

	/**
	 * updateSoftDataUpload
	 * @param id
	 * @param loginUserId
	 * @param updateSoftDataUpload
	 * @return
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	public SoftDataUpload updateSoftDataUpload (Long id, String loginUserId, UpdateSoftDataUpload updateSoftDataUpload)
			throws IllegalAccessException, InvocationTargetException {
		SoftDataUpload dbSoftDataUpload = getSoftDataUpload(id);
		BeanUtils.copyProperties(updateSoftDataUpload, dbSoftDataUpload, CommonUtils.getNullPropertyNames(updateSoftDataUpload));
		dbSoftDataUpload.setUpdatedBy(loginUserId);
		dbSoftDataUpload.setUpdatedOn(new Date());
		//return softDataUploadRepository.save(dbSoftDataUpload);
		SoftDataUpload savedSoftDataUpload = softDataUploadRepository.save(dbSoftDataUpload);

		for (UpdatePiecesDetail pdetail : updateSoftDataUpload.getPdetails()) {
			PiecesDetail dbPiecesDetail = piecesDetailService.getPiecesDetail(id);
			BeanUtils.copyProperties(pdetail, dbPiecesDetail, CommonUtils.getNullPropertyNames(pdetail));
			dbPiecesDetail.setDeletionIndicator(0L);
			dbPiecesDetail.setUpdatedBy(loginUserId);
			dbPiecesDetail.setUpdatedOn(new Date());
			dbPiecesDetail.setSoftDataUploadId(savedSoftDataUpload.getSoftDataUploadId());
			savedSoftDataUpload.getPdetails().add(piecesDetailRepository.save(dbPiecesDetail));
		}
		for (UpdateDestinationDetail ddetail : updateSoftDataUpload.getDdetails()){
			DestinationDetail dbDestinationDetail = destinationDetailService.getDestinationDetail(id);
			BeanUtils.copyProperties(ddetail, dbDestinationDetail, CommonUtils.getNullPropertyNames(ddetail));
			dbDestinationDetail.setDeletionIndicator(0L);
			dbDestinationDetail.setUpdatedBy(loginUserId);
			dbDestinationDetail.setUpdatedOn(new Date());
			dbDestinationDetail.setSoftDataUploadId(savedSoftDataUpload.getSoftDataUploadId());
//			savedSoftDataUpload.getDdetails().add(destinationDetailRepository.save(dbDestinationDetail));
		}
		for (UpdateOriginDetail odetail : updateSoftDataUpload.getOdetails()){
			OriginDetail dbOriginDetail = originDetailService.getOriginDetail(id);
			BeanUtils.copyProperties(odetail, dbOriginDetail, CommonUtils.getNullPropertyNames(odetail));
			dbOriginDetail.setDeletionIndicator(0L);
			dbOriginDetail.setUpdatedBy(loginUserId);
			dbOriginDetail.setUpdatedOn(new Date());
			dbOriginDetail.setSoftDataUploadId(savedSoftDataUpload.getSoftDataUploadId());
//			savedSoftDataUpload.getOdetails().add(originDetailRepository.save(dbOriginDetail));
		}
		for (UpdateTaxDetail tdetail : updateSoftDataUpload.getTdetails()){
			TaxDetail dbTaxDetail = taxDetailService.getTaxDetail(id);
			BeanUtils.copyProperties(tdetail, dbTaxDetail, CommonUtils.getNullPropertyNames(tdetail));
			dbTaxDetail.setDeletionIndicator(0L);
			dbTaxDetail.setUpdatedBy(loginUserId);
			dbTaxDetail.setUpdatedOn(new Date());
			dbTaxDetail.setSoftDataUploadId(savedSoftDataUpload.getSoftDataUploadId());
			savedSoftDataUpload.getTdetails().add(taxDetailRepository.save(dbTaxDetail));
		}
		for (UpdateReturnDetail rdetail : updateSoftDataUpload.getRdetails()){
			ReturnDetail dbReturnDetail = returnDetailService.getReturnDetail(id);
			BeanUtils.copyProperties(rdetail, dbReturnDetail, CommonUtils.getNullPropertyNames(rdetail));
			dbReturnDetail.setDeletionIndicator(0L);
			dbReturnDetail.setUpdatedBy(loginUserId);
			dbReturnDetail.setUpdatedOn(new Date());
			dbReturnDetail.setSoftDataUploadId(savedSoftDataUpload.getSoftDataUploadId());
			savedSoftDataUpload.getRdetails().add(returnDetailRepository.save(dbReturnDetail));
		}
		for (UpdateNode node : updateSoftDataUpload.getNodes()){
			Node dbNode = nodeService.getNode(id);
			BeanUtils.copyProperties(node, dbNode, CommonUtils.getNullPropertyNames(node));
			dbNode.setDeletionIndicator(0L);
			dbNode.setUpdatedBy(loginUserId);
			dbNode.setUpdatedOn(new Date());
			dbNode.setSoftDataUploadId(savedSoftDataUpload.getSoftDataUploadId());
			savedSoftDataUpload.getNodes().add(nodeRepository.save(dbNode));
		}
		return savedSoftDataUpload;

	}

	/**
	 * deleteSoftDataUpload
	 * @param loginUserID
	 * @param id
	 */
	public void deleteSoftDataUpload (Long id, String loginUserID) {
		SoftDataUpload softdataupload = getSoftDataUpload(id);
		if (softdataupload != null) {
			softdataupload.setDeletionIndicator(1L);
			softdataupload.setUpdatedBy(loginUserID);
			softdataupload.setUpdatedOn(new Date());
			softDataUploadRepository.save(softdataupload);
		} else {
			throw new EntityNotFoundException("Error in deleting Id: " + id);
		}
	}
}
