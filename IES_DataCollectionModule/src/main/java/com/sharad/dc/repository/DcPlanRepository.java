package com.sharad.dc.repository;

import com.sharad.dc.entity.PlanEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DcPlanRepository extends JpaRepository<PlanEntity,Integer> {
}
