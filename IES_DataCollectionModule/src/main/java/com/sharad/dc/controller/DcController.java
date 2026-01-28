package com.sharad.dc.controller;

import com.sharad.dc.binding.*;
import com.sharad.dc.service.DcManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dc-api")
public class DcController {

    @Autowired
    private DcManagementService dcManagementService;

    // generate CaseNumber

    @PostMapping("/generate-case/{appId}")
    public ResponseEntity<Integer> generateCaseNo(@PathVariable Integer appId){
        Integer caseNo = dcManagementService.generateCaseNo(appId);
        return new ResponseEntity<Integer>(caseNo,HttpStatus.CREATED);
    }

    @GetMapping("/plans")
    public ResponseEntity<List<String>> showAllPlan(){
        return new ResponseEntity<List<String>>(dcManagementService
                .showAllPlansNames(),HttpStatus.OK);
    }

    @PostMapping("/save-plan")
    public  ResponseEntity<Integer> savePlan(@RequestBody PlanSelectionInput plan){
        return new ResponseEntity<Integer>(dcManagementService
                .savePlanSelection(plan),HttpStatus.CREATED);
    }

    @PostMapping("/save-income")
    public ResponseEntity<Integer> saveIncome(@RequestBody IncomeInput income){
        return new ResponseEntity<>(dcManagementService
                .saveIncomeDetails(income),HttpStatus.CREATED);
    }

    @PostMapping("/save-education")
    public ResponseEntity<Integer> saveEducation(@RequestBody EducationInput education){
        return new ResponseEntity<Integer>(dcManagementService
                .saveEducationDetails(education),HttpStatus.CREATED);
    }

    @PostMapping("/save-children")
    public ResponseEntity<Integer> saveChildren(@RequestBody List<ChildrenInput> children){
        return new ResponseEntity<Integer>(dcManagementService
                .saveChildrenDetails(children),HttpStatus.CREATED);
    }

    @GetMapping("/get-summary/{caseNo}")
    public ResponseEntity<DcSummaryReport> showSummary(@PathVariable Integer caseNo){
        return new ResponseEntity<DcSummaryReport>(dcManagementService
                .showDCSummary(caseNo),HttpStatus.OK);
    }
}
