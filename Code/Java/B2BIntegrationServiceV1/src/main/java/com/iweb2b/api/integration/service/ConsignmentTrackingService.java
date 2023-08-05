package com.iweb2b.api.integration.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iweb2b.api.integration.config.PropertiesConfig;
import com.iweb2b.api.integration.model.softdataupload.ClientCancelOrderRequest;
import com.iweb2b.api.integration.model.softdataupload.ClientCancelOrderResponse;
import com.iweb2b.api.integration.model.tracking.AddConsignmentTracking;
import com.iweb2b.api.integration.model.tracking.ConsignmentTracking;
import com.iweb2b.api.integration.model.tracking.UpdateConsignmentTracking;
import com.iweb2b.api.integration.repository.ConsignmentTrackingRepository;
import com.iweb2b.api.integration.repository.DestinationDetailRepository;
import com.iweb2b.api.integration.repository.EventRepository;
import com.iweb2b.api.integration.repository.OriginDetailRepository;
import com.iweb2b.api.integration.repository.PiecesDetailRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ConsignmentTrackingService {
	
	@Autowired
	PropertiesConfig propertiesConfig;
	
	@Autowired
	IntegrationService integrationService;

	@Autowired
	private ConsignmentTrackingRepository consignmentTrackingRepository;

	@Autowired
	private PiecesDetailRepository piecesDetailRepository;

	@Autowired
	private DestinationDetailRepository destinationDetailRepository;

	@Autowired
	private OriginDetailRepository originDetailRepository;

	@Autowired
	private EventRepository eventRepository;

	@Autowired
	private DestinationDetailService destinationDetailService;

	@Autowired
	private PiecesDetailService piecesDetailService;

	@Autowired
	private OriginDetailService originDetailService;

	@Autowired
	private EventService eventService;

	public List<ConsignmentTracking> getConsignmentTracking() {
		List<ConsignmentTracking> consignmentTrackingList = consignmentTrackingRepository.findAll();
//		consignmentTrackingList = consignmentTrackingList.stream().filter(n -> n.getDeletionIndicator() == 0)
//				.collect(Collectors.toList());
		return consignmentTrackingList;
	}

	/**
	 * getConsignmentTracking
	 * 
	 * @param id
	 * @return
	 */
	public ConsignmentTracking getConsignmentTracking(Long id) {
//		Optional<ConsignmentTracking> consignmentTracking = consignmentTrackingRepository
//				.findByIdAndDeletionIndicator(id, 0L);
//		if (consignmentTracking.isEmpty()) {
			return null;
//		}
//		return consignmentTracking.get();
	}

	/**
	 * 
	 * @param referrenceNumber
	 * @return
	 */
	public ConsignmentTracking getConsignmentTracking (String referrenceNumber) {
		// https://demodashboardapi.shipsy.in/api/client/integration/consignment/track?reference_number=E1234567
		ConsignmentTracking consignmentTracking = integrationService.getClientConsignmentTracking(referrenceNumber);
		return consignmentTracking;
	}
	
	/**
	 * 
	 * @param clientCancelOrderRequest
	 * @return
	 */
	public ClientCancelOrderResponse cancelOrder (@Valid ClientCancelOrderRequest clientCancelOrderRequest) {
		// /api/client/integration/consignment/cancellation
		ClientCancelOrderResponse clientCancelOrderResponse = integrationService.cancelOrder (clientCancelOrderRequest);
		return clientCancelOrderResponse;
	}

	/**
	 * createConsignmentTracking
	 * 
	 * @param newConsignmentTracking
	 * @return
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	public ConsignmentTracking createConsignmentTracking (AddConsignmentTracking newConsignmentTracking,
			String loginUserId) throws IllegalAccessException, InvocationTargetException, Exception {
//		ConsignmentTracking dbConsignmentTracking = new ConsignmentTracking();
//		BeanUtils.copyProperties(newConsignmentTracking, dbConsignmentTracking,
//				CommonUtils.getNullPropertyNames(newConsignmentTracking));
////		dbConsignmentTracking.setDeletionIndicator(0L);
////		dbConsignmentTracking.setCreatedBy(loginUserId);
////		dbConsignmentTracking.setUpdatedBy(loginUserId);
////		dbConsignmentTracking.setCreatedOn(new Date());
////		dbConsignmentTracking.setUpdatedOn(new Date());
//
//		ConsignmentTracking savedConsignmentTracking = consignmentTrackingRepository.save(dbConsignmentTracking);
//
//		savedConsignmentTracking.setPdetails(new HashSet<>());
//		savedConsignmentTracking.setDdetails(new HashSet<>());
//		savedConsignmentTracking.setOdetails(new HashSet<>());
//		savedConsignmentTracking.setEvents(new HashSet<>());
//
//		for (AddPiecesDetail pdetail : newConsignmentTracking.getPdetails()) {
//			PiecesDetail dbPiecesDetail = new PiecesDetail();
//			BeanUtils.copyProperties(pdetail, dbPiecesDetail, CommonUtils.getNullPropertyNames(pdetail));
//			dbPiecesDetail.setDeletionIndicator(0L);
//			dbPiecesDetail.setCreatedBy(loginUserId);
//			dbPiecesDetail.setUpdatedBy(loginUserId);
//			dbPiecesDetail.setCreatedOn(new Date());
//			dbPiecesDetail.setUpdatedOn(new Date());
//			dbPiecesDetail.setConsignmentTrackingId(savedConsignmentTracking.getId());
//			savedConsignmentTracking.getPdetails().add(piecesDetailRepository.save(dbPiecesDetail));
//		}
//		for (AddDestinationDetail ddetail : newConsignmentTracking.getDdetails()) {
//			DestinationDetail dbDestinationDetail = new DestinationDetail();
//			BeanUtils.copyProperties(ddetail, dbDestinationDetail, CommonUtils.getNullPropertyNames(ddetail));
//			dbDestinationDetail.setDeletionIndicator(0L);
//			dbDestinationDetail.setCreatedBy(loginUserId);
//			dbDestinationDetail.setUpdatedBy(loginUserId);
//			dbDestinationDetail.setCreatedOn(new Date());
//			dbDestinationDetail.setUpdatedOn(new Date());
//			dbDestinationDetail.setConsignmentTrackingId(savedConsignmentTracking.getId());
//			savedConsignmentTracking.getDdetails().add(destinationDetailRepository.save(dbDestinationDetail));
//		}
//		for (AddOriginDetail odetail : newConsignmentTracking.getOdetails()) {
//			OriginDetail dbOriginDetail = new OriginDetail();
//			BeanUtils.copyProperties(odetail, dbOriginDetail, CommonUtils.getNullPropertyNames(odetail));
//			dbOriginDetail.setDeletionIndicator(0L);
//			dbOriginDetail.setCreatedBy(loginUserId);
//			dbOriginDetail.setUpdatedBy(loginUserId);
//			dbOriginDetail.setCreatedOn(new Date());
//			dbOriginDetail.setUpdatedOn(new Date());
//			dbOriginDetail.setConsignmentTrackingId(savedConsignmentTracking.getId());
//			savedConsignmentTracking.getOdetails().add(originDetailRepository.save(dbOriginDetail));
//		}
//		for (AddEvent event : newConsignmentTracking.getEvents()) {
//			Event dbEvent = new Event();
//			BeanUtils.copyProperties(event, dbEvent, CommonUtils.getNullPropertyNames(event));
//			dbEvent.setDeletionIndicator(0L);
//			dbEvent.setCreatedBy(loginUserId);
//			dbEvent.setUpdatedBy(loginUserId);
//			dbEvent.setCreatedOn(new Date());
//			dbEvent.setUpdatedOn(new Date());
//			dbEvent.setConsignmentTrackingId(savedConsignmentTracking.getId());
//			savedConsignmentTracking.getEvents().add(eventRepository.save(dbEvent));
//		}
//		dbConsignmentTracking.setConsignmentTrackingId(savedConsignmentTracking.getId());
//		return savedConsignmentTracking;
//
//		// return consignmentTrackingRepository.save(dbConsignmentTracking);
		return null;
	}

	/**
	 * updateConsignmentTracking
	 * 
	 * @param id
	 * @param loginUserId
	 * @param updateConsignmentTracking
	 * @return
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	public ConsignmentTracking updateConsignmentTracking(Long id, String loginUserId,
			UpdateConsignmentTracking updateConsignmentTracking)
			throws IllegalAccessException, InvocationTargetException {
//		ConsignmentTracking dbConsignmentTracking = getConsignmentTracking(id);
//		BeanUtils.copyProperties(updateConsignmentTracking, dbConsignmentTracking,
//				CommonUtils.getNullPropertyNames(updateConsignmentTracking));
////		dbConsignmentTracking.setUpdatedBy(loginUserId);
////		dbConsignmentTracking.setUpdatedOn(new Date());
//
//		ConsignmentTracking savedConsignmentTracking = consignmentTrackingRepository.save(dbConsignmentTracking);
//
//		for (UpdatePiecesDetail pdetail : updateConsignmentTracking.getPdetails()) {
//			PiecesDetail dbPiecesDetail = piecesDetailService.getPiecesDetail(id);
//			BeanUtils.copyProperties(pdetail, dbPiecesDetail, CommonUtils.getNullPropertyNames(pdetail));
//			dbPiecesDetail.setDeletionIndicator(0L);
//			dbPiecesDetail.setUpdatedBy(loginUserId);
//			dbPiecesDetail.setUpdatedOn(new Date());
//		//	dbPiecesDetail.setConsignmentTrackingId(savedConsignmentTracking.getId());
//			savedConsignmentTracking.getPdetails().add(piecesDetailRepository.save(dbPiecesDetail));
//		}
//		for (UpdateDestinationDetail ddetail : updateConsignmentTracking.getDdetails()) {
//			DestinationDetail dbDestinationDetail = destinationDetailService.getDestinationDetail(id);
//			BeanUtils.copyProperties(ddetail, dbDestinationDetail, CommonUtils.getNullPropertyNames(ddetail));
//			dbDestinationDetail.setDeletionIndicator(0L);
//			dbDestinationDetail.setUpdatedBy(loginUserId);
//			dbDestinationDetail.setUpdatedOn(new Date());
//		//	dbDestinationDetail.setConsignmentTrackingId(savedConsignmentTracking.getId());
//			savedConsignmentTracking.getDdetails().add(destinationDetailRepository.save(dbDestinationDetail));
//		}
//		for (UpdateOriginDetail odetail : updateConsignmentTracking.getOdetails()) {
//			OriginDetail dbOriginDetail = originDetailService.getOriginDetail(id);
//			BeanUtils.copyProperties(odetail, dbOriginDetail, CommonUtils.getNullPropertyNames(odetail));
//			dbOriginDetail.setDeletionIndicator(0L);
//			dbOriginDetail.setUpdatedBy(loginUserId);
//			dbOriginDetail.setUpdatedOn(new Date());
//		//	dbOriginDetail.setConsignmentTrackingId(savedConsignmentTracking.getId());
//			savedConsignmentTracking.getOdetails().add(originDetailRepository.save(dbOriginDetail));
//		}
//		for (UpdateEvent event : updateConsignmentTracking.getEvents()) {
//			Event dbEvent = eventService.getEvent(id);
//			BeanUtils.copyProperties(event, dbEvent, CommonUtils.getNullPropertyNames(event));
//			dbEvent.setDeletionIndicator(0L);
//			dbEvent.setUpdatedBy(loginUserId);
//			dbEvent.setUpdatedOn(new Date());
//		//	dbEvent.setConsignmentTrackingId(savedConsignmentTracking.getId());
//			savedConsignmentTracking.getEvents().add(eventRepository.save(dbEvent));
//		}
//		return savedConsignmentTracking;
//
//		// return consignmentTrackingRepository.save(dbConsignmentTracking);
		return null;
	}

	/**
	 * deleteConsignmentTracking
	 * 
	 * @param loginUserID
	 * @param id
	 */
	public void deleteConsignmentTracking(Long id, String loginUserID) {
		ConsignmentTracking consignmenttracking = getConsignmentTracking(id);
		if (consignmenttracking != null) {
//			consignmenttracking.setDeletionIndicator(1L);
//			consignmenttracking.setUpdatedBy(loginUserID);
//			consignmenttracking.setUpdatedOn(new Date());
			consignmentTrackingRepository.save(consignmenttracking);
		} else {
			throw new EntityNotFoundException("Error in deleting Id: " + id);
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}
