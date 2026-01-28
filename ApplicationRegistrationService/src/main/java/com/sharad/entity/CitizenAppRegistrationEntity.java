package com.sharad.entity;


import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "CITIZEN_APPLICATION")
@Data
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(
        name = "gen1_seq",
        sequenceName = "CITIZEN_APP_SEQ",
        initialValue = 1000,
        allocationSize = 1
)
public class CitizenAppRegistrationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen1_seq")
    private Integer appId;

    @Column(length = 30)
    private String fullName;

    @Column(length = 30)
    private String email;

    @Column(length = 1)
    private String gender;

    private Long phoneNo;

    private Long ssn;

    @Column(length = 30)
    private String stateName;

    private LocalDate dob;

    @Column(length = 30)
    private String createdBy;

    @Column(length = 30)
    private String updatedBy;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDate creationDate;

    @UpdateTimestamp
    @Column(insertable = false)
    private LocalDate updationDate;
}

