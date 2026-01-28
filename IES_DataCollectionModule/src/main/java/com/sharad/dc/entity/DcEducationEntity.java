package com.sharad.dc.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="DC_Education")
public class DcEducationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer educationId;
    private Integer caseNo;
    @Column(length=40)
    private String highestQlfy;
    private Integer passOutYear;
}
