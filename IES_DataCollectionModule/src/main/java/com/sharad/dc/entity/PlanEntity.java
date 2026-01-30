package com.sharad.dc.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PLAN_MASTER")
public class PlanEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer planId;
    @Column(length=30)
    private String planName;
    private LocalDate startDate;
    private LocalDate endDate;
    @Column(length=30)
    private String descrption;
    private String activeSw;
    @CreationTimestamp
    @Column(updatable=false)
    private LocalDate creationDate;
    @UpdateTimestamp
    @Column(insertable=false)
    private LocalDate updationDate;
    @Column(length=30)
    private String createdBy;
    @Column(length=30)
    private String updatedBy;
}

