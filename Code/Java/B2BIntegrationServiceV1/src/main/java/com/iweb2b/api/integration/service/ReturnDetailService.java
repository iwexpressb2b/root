package com.iweb2b.api.integration.service;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iweb2b.api.integration.model.softdataupload.AddReturnDetail;
import com.iweb2b.api.integration.model.softdataupload.ReturnDetail;
import com.iweb2b.api.integration.model.softdataupload.UpdateReturnDetail;
import com.iweb2b.api.integration.repository.ReturnDetailRepository;
import com.iweb2b.api.integration.util.CommonUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ReturnDetailService {
	
	@Autowired
	private ReturnDetailRepository returnDetailRepository;
	
	public List<ReturnDetail> getReturnDetail () {
		List<ReturnDetail> returnDetailList =  returnDetailRepository.findAll();
		returnDetailList = returnDetailList.stream().filter(n -> n.getDeletionIndicator() == 0).collect(Collectors.toList());
		return returnDetailList;
	}
	
	/**
	 * getReturnDetail
	 * @param id
	 * @return
	 */
	public ReturnDetail getReturnDetail (Long id) {
//		Optional<ReturnDetail> returnDetail = returnDetailRepository.findByIdAndDeletionIndicator(id, 0L);
//		if (returnDetail.isEmpty()) {
//			return null;
//		}
//		return returnDetail.get();
		return null;
	}
	
	/**
	 * createReturnDetail
	 * @param newReturnDetail
	 * @return
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	public ReturnDetail createReturnDetail (AddReturnDetail newReturnDetail, String loginUserId) 
			throws IllegalAccessException, InvocationTargetException, Exception {

		ReturnDetail dbReturnDetail = new ReturnDetail();
		BeanUtils.copyProperties(newReturnDetail, dbReturnDetail, CommonUtils.getNullPropertyNames(newReturnDetail));
		dbReturnDetail.setDeletionIndicator(0L);
		dbReturnDetail.setCreatedBy(loginUserId);
		dbReturnDetail.setUpdatedBy(loginUserId);
		dbReturnDetail.setCreatedOn(new Date());
		dbReturnDetail.setUpdatedOn(new Date());
		return returnDetailRepository.save(dbReturnDetail);
	}
	
	/**
	 * updateReturnDetail
	 * @param id
	 * @param loginUserId 
	 * @param updateReturnDetail
	 * @return
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	public ReturnDetail updateReturnDetail (Long id, String loginUserId, UpdateReturnDetail updateReturnDetail)
			throws IllegalAccessException, InvocationTargetException {
		ReturnDetail dbReturnDetail = getReturnDetail(id);
		BeanUtils.copyProperties(updateReturnDetail, dbReturnDetail, CommonUtils.getNullPropertyNames(updateReturnDetail));
		dbReturnDetail.setUpdatedBy(loginUserId);
		dbReturnDetail.setUpdatedOn(new Date());
		return returnDetailRepository.save(dbReturnDetail);
	}
	
	/**
	 * deleteReturnDetail
	 * @param loginUserID 
	 * @param id
	 */
	public void deleteReturnDetail (Long id, String loginUserID) {
		ReturnDetail returndetail = getReturnDetail(id);
		if (returndetail != null) {
			returndetail.setDeletionIndicator(1L);
			returndetail.setUpdatedBy(loginUserID);
			returndetail.setUpdatedOn(new Date());
			returnDetailRepository.save(returndetail);
		} else {
			throw new EntityNotFoundException("Error in deleting Id: " + id);
		}
	}
}
