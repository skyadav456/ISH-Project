package com.sharad.dc.binding;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ChildrenInput {
    private Integer childId;
    private Integer caseNo;
    private LocalDate childDOB;
    private Long childSSN;
}
