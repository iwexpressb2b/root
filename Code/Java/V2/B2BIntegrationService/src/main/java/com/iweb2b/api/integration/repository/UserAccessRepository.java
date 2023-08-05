package com.iweb2b.api.integration.repository;

import com.iweb2b.api.integration.model.usermanagement.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserAccessRepository extends JpaRepository<UserAccess, Long>, JpaSpecificationExecutor<UserAccess> {

	public Optional<UserAccess> findByUserIdAndDeletionIndicator(String userId, Long deletionIndicator);

	UserAccess findByLanguageIdAndCompanyCodeAndUserIdAndUserRoleIdAndDeletionIndicator(
			String languageId, String companyCode, String userId, Long userRoleId, Long deletionIndicator);

    UserAccess findByLanguageIdAndCompanyCodeAndUserIdAndDeletionIndicator(
			String languageId, String companyCode, String userId, Long deletionIndicator);
}