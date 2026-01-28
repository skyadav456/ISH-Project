package com.sharad.dc.repository;

import com.sharad.dc.entity.DcEducationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DcEducationRepository extends JpaRepository<DcEducationEntity,Integer> {
    public DcEducationEntity findByCaseNo(int caseNo);
}
