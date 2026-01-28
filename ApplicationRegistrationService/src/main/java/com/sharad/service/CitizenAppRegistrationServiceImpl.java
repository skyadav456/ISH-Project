package com.sharad.service;

import com.sharad.binding.CitizenAppRegistrationInput;
import com.sharad.config.AppConfig;
import com.sharad.entity.CitizenAppRegistrationEntity;
import com.sharad.exception.InvalidSSNException;
import com.sharad.repository.CitizenAppRegistrationRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class CitizenAppRegistrationServiceImpl implements CitizenAppRegistrationService {
    @Autowired
    private CitizenAppRegistrationRepository repository;
    @Autowired
    private RestTemplate template;
    @Autowired
    private WebClient webClient;

    @Value("${ssa.web.api.url}")
    private String endPointUrl;

    @Value("${ar.state}")
    private String targetState;

    @Override
    public Integer registerCitizenApplication(CitizenAppRegistrationInput input) {
        String stateName = webClient
                .get()
                .uri(endPointUrl, input.getSsn())
                .retrieve()
                .onStatus(
                        HttpStatus.BAD_REQUEST::equals,
                        res -> res.bodyToMono(String.class)
                                .flatMap(body ->
                                        Mono.error(
                                                new InvalidSSNException("Invalid SSN")
                                        )
                                )
                )
                .bodyToMono(String.class)
                .block();
        if (stateName.equalsIgnoreCase(targetState)) {
            CitizenAppRegistrationEntity entity = new CitizenAppRegistrationEntity();
            BeanUtils.copyProperties(input, entity);
            entity.setStateName(stateName);
            Integer appId = repository.save(entity).getAppId();
            return appId;
        }
        throw  new InvalidSSNException("Invalid SSN ");
    }
}
