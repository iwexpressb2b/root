package com.iweb2b.api.integration.service;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iweb2b.api.integration.model.AddDestinationDetail;
import com.iweb2b.api.integration.model.DestinationDetail;
import com.iweb2b.api.integration.model.UpdateDestinationDetail;
import com.iweb2b.api.integration.repository.DestinationDetailRepository;
import com.iweb2b.api.integration.util.CommonUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class DestinationDetailService {
	
	@Autowired
	private DestinationDetailRepository destinationDetailRepository;
	
	public List<DestinationDetail> getDestinationDetail () {
		List<DestinationDetail> destinationDetailList =  destinationDetailRepository.findAll();
		destinationDetailList = destinationDetailList.stream().filter(n -> n.getDeletionIndicator() == 0).collect(Collectors.toList());
		return destinationDetailList;
	}
	
	/**
	 * getDestinationDetail
	 * @param id
	 * @return
	 */
	public DestinationDetail getDestinationDetail (Long id) {
//		Optional<DestinationDetail> destinationDetail = destinationDetailRepository.findByIdAndDeletionIndicator(id, 0L);
//		if (destinationDetail.isEmpty()) {
//			return null;
//		}
//		return destinationDetail.get();
		return null;
	}
	
	/**
	 * createDestinationDetail
	 * @param newDestinationDetail
	 * @return
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	public DestinationDetail createDestinationDetail (AddDestinationDetail newDestinationDetail, String loginUserId) 
			throws IllegalAccessException, InvocationTargetException, Exception {

		DestinationDetail dbDestinationDetail = new DestinationDetail();
		BeanUtils.copyProperties(newDestinationDetail, dbDestinationDetail, CommonUtils.getNullPropertyNames(newDestinationDetail));
		dbDestinationDetail.setDeletionIndicator(0L);
		dbDestinationDetail.setCreatedBy(loginUserId);
		dbDestinationDetail.setUpdatedBy(loginUserId);
		dbDestinationDetail.setCreatedOn(new Date());
		dbDestinationDetail.setUpdatedOn(new Date());
		return destinationDetailRepository.save(dbDestinationDetail);
	}
	
	/**
	 * updateDestinationDetail
	 * @param id
	 * @param loginUserId 
	 * @param updateDestinationDetail
	 * @return
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	public DestinationDetail updateDestinationDetail (Long id, String loginUserId, UpdateDestinationDetail updateDestinationDetail)
			throws IllegalAccessException, InvocationTargetException {
		DestinationDetail dbDestinationDetail = getDestinationDetail(id);
		BeanUtils.copyProperties(updateDestinationDetail, dbDestinationDetail, CommonUtils.getNullPropertyNames(updateDestinationDetail));
		dbDestinationDetail.setUpdatedBy(loginUserId);
		dbDestinationDetail.setUpdatedOn(new Date());
		return destinationDetailRepository.save(dbDestinationDetail);
	}
	
	/**
	 * deleteDestinationDetail
	 * @param loginUserID 
	 * @param id
	 */
	public void deleteDestinationDetail (Long id, String loginUserID) {
		DestinationDetail destinationdetail = getDestinationDetail(id);
		if (destinationdetail != null) {
			destinationdetail.setDeletionIndicator(1L);
			destinationdetail.setUpdatedBy(loginUserID);
			destinationdetail.setUpdatedOn(new Date());
			destinationDetailRepository.save(destinationdetail);
		} else {
			throw new EntityNotFoundException("Error in deleting Id: " + id);
		}
	}
}
