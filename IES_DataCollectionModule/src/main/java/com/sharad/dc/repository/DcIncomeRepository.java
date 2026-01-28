package com.sharad.dc.repository;

import com.sharad.dc.entity.DcIncomeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DcIncomeRepository extends JpaRepository<DcIncomeEntity,Integer> {

    public DcIncomeEntity findByCaseNo(int caseNo);


}
