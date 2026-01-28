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
@Table(name="CITIZEN_APPLICATION")
public class CitizenAppRegistrationEntity {
    @SequenceGenerator(name="gen1",sequenceName="App_ID_SEQ",
            initialValue = 1000,allocationSize=1)

    @GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)

    @Id
    private Integer appId;

    @Column(length=30)


    private String  fullName;
    @Column(length=30)
    private String  email;

    private Long  phno;

    private Long  ssn;
    @Column(length=1)
    private String  gender;
    private LocalDate dob;

    @Column(length=30)
    private String  stateName;

    @Column(length=30)
    private String  createdBy;
    @Column(length=30)
    private String  updatedBy;

    @CreationTimestamp
    @Column(updatable=false)
    private LocalDate  createdDate;
    @UpdateTimestamp
    @Column(insertable=false)
    private LocalDate  updatedDate;
}
