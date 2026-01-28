package com.sharad.service;


import org.springframework.stereotype.Service;

@Service
public class StateService {

    public String getState(String number) {

        int lastTwoDigits = Integer.parseInt(number.substring(7));

        if (lastTwoDigits ==04) {
            return "CALIFORNIA";
        } else if (lastTwoDigits ==02) {
            return "TEXAS";
        } else if (lastTwoDigits ==01) {
            return "NEW_YORK";
        } else if (lastTwoDigits ==03) {
            return "FLORIDA";
        } else {
            return "Invalid Number";
        }
    }
}

