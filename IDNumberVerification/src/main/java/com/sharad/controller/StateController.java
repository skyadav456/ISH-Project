package com.sharad.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sharad.service.StateService;

@RestController
@RequestMapping("/state")
public class StateController {

    private final StateService stateService;

    public StateController(StateService stateService) {
        this.stateService = stateService;
    }

    @GetMapping("/{number}")
    public String getState(@PathVariable long number) {

        String numStr = String.valueOf(number);

        // Check length of number
        if (numStr.length() != 9) {
            return "INVALID_INPUT";
        }
        return stateService.getState(numStr);
    }
}
