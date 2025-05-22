package com.example.Micro_Resource.DTO;

import com.example.Micro_Resource.Enums.ExitReason;
import lombok.*;

import java.time.LocalDate;


import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
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

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getCurrentYear() {
        return currentYear;
    }

    public String getPhone() {
        return phone;
    }

    public LocalDate getDob() {
        return dob;
    }

    public String getParentsFirstName() {
        return parentsFirstName;
    }

    public String getParentsLastName() {
        return parentsLastName;
    }
    public Double getLastPercentage() {
        return lastPercentage;
    }

    public Integer getAdmissionClass() {
        return admissionClass;
    }

    public LocalDate getAdmissionYear() {
        return admissionYear;
    }

    public Integer getPassOutClass() {
        return passOutClass;
    }
    public LocalDate getPassOutYear() {
        return passOutYear;
    }
    public String getAadharNo() {
        return aadharNo;
    }

    public ExitReason getExitReason() {
        return exitReason;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public void setCurrentYear(Integer currentYear) {
        this.currentYear = currentYear;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public void setParentsFirstName(String parentsFirstName) {
        this.parentsFirstName = parentsFirstName;
    }

    public void setParentsLastName(String parentsLastName) {
        this.parentsLastName = parentsLastName;
    }

    public void setLastPercentage(Double lastPercentage) {
        this.lastPercentage = lastPercentage;
    }

    public void setAdmissionClass(Integer admissionClass) {
        this.admissionClass = admissionClass;
    }
 public void setAdmissionYear(LocalDate admissionYear) {
        this.admissionYear = admissionYear;
    }

    public void setPassOutClass(Integer passOutClass) {
        this.passOutClass = passOutClass;
    }
    public void setPassOutYear(LocalDate passOutYear) {
        this.passOutYear = passOutYear;
    }


    public void setExitReason(ExitReason exitReason) {
        this.exitReason = exitReason;
    }
}
