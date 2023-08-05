package com.iweb2b.api.integration.service;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iweb2b.api.integration.model.softdataupload.AddNode;
import com.iweb2b.api.integration.model.softdataupload.Node;
import com.iweb2b.api.integration.model.softdataupload.UpdateNode;
import com.iweb2b.api.integration.repository.NodeRepository;
import com.iweb2b.api.integration.util.CommonUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class NodeService {
	
	@Autowired
	private NodeRepository nodeRepository;
	
	public List<Node> getNode () {
		List<Node> nodeList =  nodeRepository.findAll();
		nodeList = nodeList.stream().filter(n -> n.getDeletionIndicator() == 0).collect(Collectors.toList());
		return nodeList;
	}
	
	/**
	 * getNode
	 * @param id
	 * @return
	 */
	public Node getNode (Long id) {
//		Optional<Node> node = nodeRepository.findByIdAndDeletionIndicator(id, 0L);
//		if (node.isEmpty()) {
//			return null;
//		}
//		return node.get();
		return null;
	}
	
	/**
	 * createNode
	 * @param newNode
	 * @return
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	public Node createNode (AddNode newNode, String loginUserId) 
			throws IllegalAccessException, InvocationTargetException, Exception {

		Node dbNode = new Node();
		BeanUtils.copyProperties(newNode, dbNode, CommonUtils.getNullPropertyNames(newNode));
		dbNode.setDeletionIndicator(0L);
		dbNode.setCreatedBy(loginUserId);
		dbNode.setUpdatedBy(loginUserId);
		dbNode.setCreatedOn(new Date());
		dbNode.setUpdatedOn(new Date());
		return nodeRepository.save(dbNode);
	}
	
	/**
	 * updateNode
	 * @param id
	 * @param loginUserId 
	 * @param updateNode
	 * @return
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	public Node updateNode (Long id, String loginUserId, UpdateNode updateNode)
			throws IllegalAccessException, InvocationTargetException {
		Node dbNode = getNode(id);
		BeanUtils.copyProperties(updateNode, dbNode, CommonUtils.getNullPropertyNames(updateNode));
		dbNode.setUpdatedBy(loginUserId);
		dbNode.setUpdatedOn(new Date());
		return nodeRepository.save(dbNode);
	}
	
	/**
	 * deleteNode
	 * @param loginUserID 
	 * @param id
	 */
	public void deleteNode (Long id, String loginUserID) {
		Node node = getNode(id);
		if (node != null) {
			node.setDeletionIndicator(1L);
			node.setUpdatedBy(loginUserID);
			node.setUpdatedOn(new Date());
			nodeRepository.save(node);
		} else {
			throw new EntityNotFoundException("Error in deleting Id: " + id);
		}
	}
}
