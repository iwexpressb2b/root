package com.iweb2b.api.integration.service;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iweb2b.api.integration.model.AddOriginDetail;
import com.iweb2b.api.integration.model.OriginDetail;
import com.iweb2b.api.integration.model.UpdateOriginDetail;
import com.iweb2b.api.integration.repository.OriginDetailRepository;
import com.iweb2b.api.integration.util.CommonUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class OriginDetailService {
	
	@Autowired
	private OriginDetailRepository originDetailRepository;
	
	public List<OriginDetail> getOriginDetail () {
		List<OriginDetail> originDetailList =  originDetailRepository.findAll();
		originDetailList = originDetailList.stream().filter(n -> n.getDeletionIndicator() == 0).collect(Collectors.toList());
		return originDetailList;
	}
	
	/**
	 * getOriginDetail
	 * @param id
	 * @return
	 */
	public OriginDetail getOriginDetail (Long id) {
//		Optional<OriginDetail> originDetail = originDetailRepository.findByIdAndDeletionIndicator(id, 0L);
//		if (originDetail.isEmpty()) {
//			return null;
//		}
//		return originDetail.get();
		return null;
	}
	
	/**
	 * createOriginDetail
	 * @param newOriginDetail
	 * @return
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	public OriginDetail createOriginDetail (AddOriginDetail newOriginDetail, String loginUserId) 
			throws IllegalAccessException, InvocationTargetException, Exception {

		OriginDetail dbOriginDetail = new OriginDetail();
		BeanUtils.copyProperties(newOriginDetail, dbOriginDetail, CommonUtils.getNullPropertyNames(newOriginDetail));
		dbOriginDetail.setDeletionIndicator(0L);
		dbOriginDetail.setCreatedBy(loginUserId);
		dbOriginDetail.setUpdatedBy(loginUserId);
		dbOriginDetail.setCreatedOn(new Date());
		dbOriginDetail.setUpdatedOn(new Date());
		return originDetailRepository.save(dbOriginDetail);
	}
	
	/**
	 * updateOriginDetail
	 * @param id
	 * @param loginUserId 
	 * @param updateOriginDetail
	 * @return
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	public OriginDetail updateOriginDetail (Long id, String loginUserId, UpdateOriginDetail updateOriginDetail)
			throws IllegalAccessException, InvocationTargetException {
		OriginDetail dbOriginDetail = getOriginDetail(id);
		BeanUtils.copyProperties(updateOriginDetail, dbOriginDetail, CommonUtils.getNullPropertyNames(updateOriginDetail));
		dbOriginDetail.setUpdatedBy(loginUserId);
		dbOriginDetail.setUpdatedOn(new Date());
		return originDetailRepository.save(dbOriginDetail);
	}
	
	/**
	 * deleteOriginDetail
	 * @param loginUserID 
	 * @param id
	 */
	public void deleteOriginDetail (Long id, String loginUserID) {
		OriginDetail origindetail = getOriginDetail(id);
		if (origindetail != null) {
			origindetail.setDeletionIndicator(1L);
			origindetail.setUpdatedBy(loginUserID);
			origindetail.setUpdatedOn(new Date());
			originDetailRepository.save(origindetail);
		} else {
			throw new EntityNotFoundException("Error in deleting Id: " + id);
		}
	}
}
