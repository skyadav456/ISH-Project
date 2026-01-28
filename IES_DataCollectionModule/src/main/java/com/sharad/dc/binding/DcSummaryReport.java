package com.sharad.dc.binding;
import lombok.Data;
import java.util.List;

@Data
public class DcSummaryReport {

    private EducationInput education;
    private PlanSelectionInput planDetails;
    private List<ChildrenInput> childrenDetails;
    private IncomeInput incomeDetails;
    private CitizenAppRegistrationInput citizenDetails;
    private String planName;
}
