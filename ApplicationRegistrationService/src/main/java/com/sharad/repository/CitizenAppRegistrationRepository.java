package com.sharad.repository;



import com.sharad.entity.CitizenAppRegistrationEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CitizenAppRegistrationRepository
        extends JpaRepository<CitizenAppRegistrationEntity, Integer> {

}

