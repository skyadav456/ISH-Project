package com.sharad.dc.service;

import com.sharad.dc.binding.*;
import com.sharad.dc.entity.*;
import com.sharad.dc.exception.ResourceNotFoundException;
import com.sharad.dc.repository.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DcManagementServiceImpl implements DcManagementService {

    @Autowired
    private ApplicationRegistrationRepository citizenRepository;

    @Autowired
    private DcCaseRepository caseRepository;
    @Autowired
    private DcChildrenRepository childrenRepository;
    @Autowired
    private  DcEducationRepository educationRepository;
    @Autowired
    private DcIncomeRepository incomeRepository;
    @Autowired
    private DcPlanRepository planRepository;



    @Override
    public Integer generateCaseNo(Integer appId) {
        // Validate app Id
        Optional<CitizenAppRegistrationEntity> citizenId = citizenRepository.findById(appId);
        if(citizenId.isPresent()){
            DcCaseEntity caseEntity= new DcCaseEntity();
            caseEntity.setAppId(appId);
            return caseRepository.save(caseEntity).getCaseNo();
        }
        return 0;
    }


    @Override
    public List<String> showAllPlansNames() {
        List<String> planList = planRepository.findAll()
                .stream()
                .map(PlanEntity::getPlanName)
                .toList();
        return planList;
    }

    @Override
    public Integer savePlanSelection(PlanSelectionInput plan) {
        DcCaseEntity dcCaseEntity = caseRepository.findById(plan.getCaseNo())
                .orElseThrow(() -> new ResourceAccessException(" invalid case Number !"));
        dcCaseEntity.setPlanId(plan.getPlanId());
        caseRepository.save(dcCaseEntity);
        return dcCaseEntity.getCaseNo();
    }

    @Override
    public Integer saveIncomeDetails(IncomeInput income) {
        caseRepository.findById(income.getCaseNo())
                .orElseThrow(()->new ResourceNotFoundException("invalid case Number"));
        DcIncomeEntity incomeEntity= new DcIncomeEntity();
        BeanUtils.copyProperties(income,incomeEntity);

        /* in place of beans Utils
            incomeEntity.setCaseNo(income.getCaseNo());
            incomeEntity.setEmpIncome(income.getEmpIncome());
            incomeEntity.setPropertyIncome(income.getPropertyIncome());
       */
        // save the income detail
        incomeRepository.save(incomeEntity);
        return income.getCaseNo();
    }

    @Override
    public Integer saveEducationDetails(EducationInput education) {
        caseRepository.findById(education.getCaseNo())
                .orElseThrow(()->new ResourceNotFoundException("invalid case Number"));

        DcEducationEntity educationEntity = new DcEducationEntity();
        BeanUtils.copyProperties(education,educationEntity);
        educationRepository.save(educationEntity);
        return education.getCaseNo();
    }

    @Override
    public Integer saveChildrenDetails(List<ChildrenInput> children) {
        //convert each binding class Object to entity class Object
        children.forEach(ch->{
            DcChildrenEntity childrenEntity = new DcChildrenEntity();
            BeanUtils.copyProperties(ch,childrenEntity);
            childrenRepository.save(childrenEntity);
        });
        // returning case number
        return children.getFirst().getCaseNo();

    }

    @Override
    public DcSummaryReport showDCSummary(Integer caseNo) {

        // 1. Validate Case
        DcCaseEntity caseEntity = caseRepository.findById(caseNo)
                .orElseThrow(() -> new ResourceNotFoundException("Invalid Case No"));

        // 2. Fetch related data
        DcIncomeEntity incomeEntity = incomeRepository.findByCaseNo(caseNo);
        DcEducationEntity educationEntity = educationRepository.findByCaseNo(caseNo);
        List<DcChildrenEntity> childrenEntityList =
                childrenRepository.findByCaseNo(caseNo);

        // 3. Get Plan Name
        String planName = planRepository.findById(caseEntity.getPlanId())
                .map(PlanEntity::getPlanName)
                .orElse("N/A");

        // 4. Get Citizen Details
        CitizenAppRegistrationEntity citizenEntity =
                citizenRepository.findById(caseEntity.getAppId())
                        .orElseThrow(() ->
                                new ResourceNotFoundException("Citizen not found"));

        // 5. Convert Entities → DTOs
        IncomeInput incomeInput = new IncomeInput();
        BeanUtils.copyProperties(incomeEntity, incomeInput);

        EducationInput educationInput = new EducationInput();
        BeanUtils.copyProperties(educationEntity, educationInput);

        List<ChildrenInput> childInputs = new ArrayList<>();
        for (DcChildrenEntity ch : childrenEntityList) {
            ChildrenInput child = new ChildrenInput();
            BeanUtils.copyProperties(ch, child);
            childInputs.add(child);
        }

        CitizenAppRegistrationInput citizenInput = new CitizenAppRegistrationInput();
        BeanUtils.copyProperties(citizenEntity, citizenInput);

        // 6. Prepare Summary
        DcSummaryReport report = new DcSummaryReport();
        // report.setCaseNo(caseNo);
        report.setPlanName(planName);
        report.setIncomeDetails(incomeInput);
        report.setEducation(educationInput);
        report.setChildrenDetails(childInputs);
        report.setCitizenDetails(citizenInput);

        return report;
    }

}
