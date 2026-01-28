package com.sharad.dc.binding;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
public class CitizenAppRegistrationInput {

    private String  fullName;
    private String  email;
    private Long  ph_no;
    private Long  ssn;
    private String  gender;
    private LocalDate dob;
}
