package com.iweb2b.api.integration.service;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iweb2b.api.integration.model.softdataupload.AddTaxDetail;
import com.iweb2b.api.integration.model.softdataupload.TaxDetail;
import com.iweb2b.api.integration.model.softdataupload.UpdateTaxDetail;
import com.iweb2b.api.integration.repository.TaxDetailRepository;
import com.iweb2b.api.integration.util.CommonUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TaxDetailService {
	
	@Autowired
	private TaxDetailRepository taxDetailRepository;
	
	public List<TaxDetail> getTaxDetail () {
		List<TaxDetail> taxDetailList =  taxDetailRepository.findAll();
		taxDetailList = taxDetailList.stream().filter(n -> n.getDeletionIndicator() == 0).collect(Collectors.toList());
		return taxDetailList;
	}
	
	/**
	 * getTaxDetail
	 * @param id
	 * @return
	 */
	public TaxDetail getTaxDetail (Long id) {
//		Optional<TaxDetail> taxDetail = taxDetailRepository.findByIdAndDeletionIndicator(id, 0L);
//		if (taxDetail.isEmpty()) {
//			return null;
//		}
//		return taxDetail.get();
		return null;
	}
	
	/**
	 * createTaxDetail
	 * @param newTaxDetail
	 * @return
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	public TaxDetail createTaxDetail (AddTaxDetail newTaxDetail, String loginUserId) 
			throws IllegalAccessException, InvocationTargetException, Exception {

		TaxDetail dbTaxDetail = new TaxDetail();
		BeanUtils.copyProperties(newTaxDetail, dbTaxDetail, CommonUtils.getNullPropertyNames(newTaxDetail));
		dbTaxDetail.setDeletionIndicator(0L);
		dbTaxDetail.setCreatedBy(loginUserId);
		dbTaxDetail.setUpdatedBy(loginUserId);
		dbTaxDetail.setCreatedOn(new Date());
		dbTaxDetail.setUpdatedOn(new Date());
		return taxDetailRepository.save(dbTaxDetail);
	}
	
	/**
	 * updateTaxDetail
	 * @param id
	 * @param loginUserId 
	 * @param updateTaxDetail
	 * @return
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	public TaxDetail updateTaxDetail (Long id, String loginUserId, UpdateTaxDetail updateTaxDetail)
			throws IllegalAccessException, InvocationTargetException {
		TaxDetail dbTaxDetail = getTaxDetail(id);
		BeanUtils.copyProperties(updateTaxDetail, dbTaxDetail, CommonUtils.getNullPropertyNames(updateTaxDetail));
		dbTaxDetail.setUpdatedBy(loginUserId);
		dbTaxDetail.setUpdatedOn(new Date());
		return taxDetailRepository.save(dbTaxDetail);
	}
	
	/**
	 * deleteTaxDetail
	 * @param loginUserID 
	 * @param id
	 */
	public void deleteTaxDetail (Long id, String loginUserID) {
		TaxDetail taxdetail = getTaxDetail(id);
		if (taxdetail != null) {
			taxdetail.setDeletionIndicator(1L);
			taxdetail.setUpdatedBy(loginUserID);
			taxdetail.setUpdatedOn(new Date());
			taxDetailRepository.save(taxdetail);
		} else {
			throw new EntityNotFoundException("Error in deleting Id: " + id);
		}
	}
}
