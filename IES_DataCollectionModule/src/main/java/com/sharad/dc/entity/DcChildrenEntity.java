package com.sharad.dc.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="DC_Children")
public class DcChildrenEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Integer childId;
    private Integer caseNo;
    private LocalDate childDOB;
    private Long childSSN;

}
