package com.example.Micro_Resource.Entity;

import com.example.Micro_Resource.Enums.ExitReason;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Integer studentId;

    @Column(name = "FirstName", nullable = false, length = 50)
    private String firstName;

    @Column(name = "LastName", nullable = false, length = 50)
    private String lastName;

    @Column(name = "Currentt_Year")
    private Integer currentYear;

    @Column(name = "phone", nullable = false, length = 10, unique = true)
    private String phone;

    @Column(name = "Dob")
    private LocalDate dob;

    @Column(name = "Password_Hash", nullable = false, length = 256)
    // letting password to set as front end is not there
  //  @Getter(AccessLevel.NONE)
    private String passwordHash;

    @Column(name = "Parents_FirstName", nullable = false, length = 50)
    private String parentsFirstName;

    @Column(name = "Parents_LastName", nullable = false, length = 50)
    private String parentsLastName;

    @Column(name = "Last_Percentage", precision = 4, scale = 2)
    private Double lastPercentage;

    @Column(name = "AdminSsion_Class")
    private Integer admissionClass;

    @Column(name = "Admission_Year")
    private LocalDate admissionYear;

    @Column(name = "PassOut_Class")
    private Integer passOutClass;

    @Column(name = "PassOut_Year")
    private LocalDate passOutYear;

    @Column(name = "Aadhar_No", length = 16, nullable = false, unique = true)
    private String aadharNo;

    @Enumerated(EnumType.STRING)
    @Column(name = "Exit_reason")
    private ExitReason exitReason;


}

