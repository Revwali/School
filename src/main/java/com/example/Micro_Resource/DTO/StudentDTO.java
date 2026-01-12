package com.example.Micro_Resource.DTO;

import com.example.Micro_Resource.Enums.StudentExitReason;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;


import lombok.Builder;
import lombok.Data;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StudentDTO {

    private Integer studentId;
    private String firstName;
    private String lastName;
    private Integer currentYear;
    private String phone;
    private LocalDate dob;
    private String parentsFirstName;
    private String parentsLastName;
    private BigDecimal lastPercentage;
    private Integer admissionClass;
    private LocalDate admissionYear;
    private Integer passOutClass;
    private LocalDate passOutYear;
    private String aadharNo;
    private StudentExitReason studentExitReason;

    public void setAadharNo(String aadharNo) {
        this.aadharNo = aadharNo;
    }

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
    public BigDecimal getLastPercentage() {
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

    public StudentExitReason getStudentExitReason() {
        return studentExitReason;
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

    public void setLastPercentage(BigDecimal lastPercentage) {
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


    public void setStudentExitReason(StudentExitReason studentExitReason) {
        this.studentExitReason = studentExitReason;
    }
}
