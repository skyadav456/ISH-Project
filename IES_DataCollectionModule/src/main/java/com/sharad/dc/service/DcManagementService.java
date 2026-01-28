package com.sharad.dc.service;

import com.sharad.dc.binding.*;

import java.util.List;

public interface DcManagementService {

    public Integer generateCaseNo(Integer appId);
    public List<String> showAllPlansNames();
    public Integer savePlanSelection(PlanSelectionInput plan);
    public  Integer  saveIncomeDetails(IncomeInput income);
    public Integer saveEducationDetails (EducationInput education);
    public Integer saveChildrenDetails (List<ChildrenInput> children);
    public DcSummaryReport showDCSummary(Integer caseNo);
}
