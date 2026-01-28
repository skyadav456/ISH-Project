package com.sharad.dc.repository;

import com.sharad.dc.entity.DcChildrenEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DcChildrenRepository extends JpaRepository<DcChildrenEntity,Integer> {

    List< DcChildrenEntity > findByCaseNo(int caseNo);
}
