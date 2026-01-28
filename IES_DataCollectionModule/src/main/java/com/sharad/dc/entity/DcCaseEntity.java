package com.sharad.dc.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="DC_CASES")
public class DcCaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer caseId;
    private Integer caseNo;
    private Integer appId;
    private Integer planId;
}
