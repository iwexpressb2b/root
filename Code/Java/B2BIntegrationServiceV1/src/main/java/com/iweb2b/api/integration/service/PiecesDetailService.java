package com.iweb2b.api.integration.service;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iweb2b.api.integration.model.AddPiecesDetail;
import com.iweb2b.api.integration.model.PiecesDetail;
import com.iweb2b.api.integration.model.UpdatePiecesDetail;
import com.iweb2b.api.integration.repository.PiecesDetailRepository;
import com.iweb2b.api.integration.util.CommonUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PiecesDetailService {
	
	@Autowired
	private PiecesDetailRepository piecesDetailRepository;
	
	public List<PiecesDetail> getPiecesDetail () {
		List<PiecesDetail> piecesDetailList =  piecesDetailRepository.findAll();
		piecesDetailList = piecesDetailList.stream().filter(n -> n.getDeletionIndicator() == 0).collect(Collectors.toList());
		return piecesDetailList;
	}
	
	/**
	 * getPiecesDetail
	 * @param id
	 * @return
	 */
	public PiecesDetail getPiecesDetail (Long id) {
//		Optional<PiecesDetail> piecesDetail = piecesDetailRepository.findByIdAndDeletionIndicator(id, 0L);
//		if (piecesDetail.isEmpty()) {
//			return null;
//		}
//		return piecesDetail.get();
		return null;
	}
	
	/**
	 * createPiecesDetail
	 * @param newPiecesDetail
	 * @return
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	public PiecesDetail createPiecesDetail (AddPiecesDetail newPiecesDetail, String loginUserId) 
			throws IllegalAccessException, InvocationTargetException, Exception {

		PiecesDetail dbPiecesDetail = new PiecesDetail();
		BeanUtils.copyProperties(newPiecesDetail, dbPiecesDetail, CommonUtils.getNullPropertyNames(newPiecesDetail));
		dbPiecesDetail.setDeletionIndicator(0L);
		dbPiecesDetail.setCreatedBy(loginUserId);
		dbPiecesDetail.setUpdatedBy(loginUserId);
		dbPiecesDetail.setCreatedOn(new Date());
		dbPiecesDetail.setUpdatedOn(new Date());
		return piecesDetailRepository.save(dbPiecesDetail);
	}
	
	/**
	 * updatePiecesDetail
	 * @param id
	 * @param loginUserId 
	 * @param updatePiecesDetail
	 * @return
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	public PiecesDetail updatePiecesDetail (Long id, String loginUserId, UpdatePiecesDetail updatePiecesDetail)
			throws IllegalAccessException, InvocationTargetException {
		PiecesDetail dbPiecesDetail = getPiecesDetail(id);
		BeanUtils.copyProperties(updatePiecesDetail, dbPiecesDetail, CommonUtils.getNullPropertyNames(updatePiecesDetail));
		dbPiecesDetail.setUpdatedBy(loginUserId);
		dbPiecesDetail.setUpdatedOn(new Date());
		return piecesDetailRepository.save(dbPiecesDetail);
	}
	
	/**
	 * deletePiecesDetail
	 * @param loginUserID 
	 * @param id
	 */
	public void deletePiecesDetail (Long id, String loginUserID) {
		PiecesDetail piecesdetail = getPiecesDetail(id);
		if (piecesdetail != null) {
			piecesdetail.setDeletionIndicator(1L);
			piecesdetail.setUpdatedBy(loginUserID);
			piecesdetail.setUpdatedOn(new Date());
			piecesDetailRepository.save(piecesdetail);
		} else {
			throw new EntityNotFoundException("Error in deleting Id: " + id);
		}
	}
}
