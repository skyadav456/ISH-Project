package com.sharad.dc.repository;

import com.sharad.dc.entity.CitizenAppRegistrationEntity;
import com.sharad.dc.entity.DcCaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DcCaseRepository extends JpaRepository<DcCaseEntity,Integer> {
}
