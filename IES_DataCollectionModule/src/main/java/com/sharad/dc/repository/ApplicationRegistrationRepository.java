package com.sharad.dc.repository;

import com.sharad.dc.entity.CitizenAppRegistrationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationRegistrationRepository
        extends JpaRepository<CitizenAppRegistrationEntity, Integer> {
}

