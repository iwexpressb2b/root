package com.iweb2b.api.integration.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iweb2b.api.integration.model.softdataupload.Node;

@Repository
public interface NodeRepository extends JpaRepository<Node, Long>{

    public List<Node> findAll();

//    public Optional<Node> findByIdAndDeletionIndicator(Long Id, long l);
}