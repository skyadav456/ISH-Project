package com.sharad.controller;

import com.sharad.binding.CitizenAppRegistrationInput;
import com.sharad.entity.CitizenAppRegistrationEntity;
import com.sharad.service.CitizenAppRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/CitizenAR-api")
public class CitizenAppRegistrationController {
    @Autowired
    private CitizenAppRegistrationService service;

    @PostMapping("/save")
    public ResponseEntity<String> createCitizenAppRegistration(@RequestBody CitizenAppRegistrationInput input) throws Exception{
        Integer appId = service.registerCitizenApplication(input);
        if (appId > 0) {
            return new ResponseEntity<String>("Citizen Application is register with ID: " + appId, HttpStatus.CREATED);

        } else {
            return new ResponseEntity<String>("Invalid SSN or citizen must belong to California ", HttpStatus.BAD_REQUEST);
        }
    }

}
