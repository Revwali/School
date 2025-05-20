package com.example.Micro_Resource.DTO;

import com.example.Micro_Resource.Enums.ExitReason;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;


import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
@Builder
@Data
public class StudentDTO {

    private Integer studentId;
    private String firstName;
    private String lastName;
    private Integer currentYear;
    private String phone;
    private LocalDate dob;
    private String parentsFirstName;
    private String parentsLastName;
    private Double lastPercentage;
    private Integer admissionClass;
    private LocalDate admissionYear;
    private Integer passOutClass;
    private LocalDate passOutYear;
    private String aadharNo;
    private ExitReason exitReason;

}
