package com.example.Micro_Resource.Entity;

import com.example.Micro_Resource.Enums.ExitReason;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
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

    @Column(name = "first_name", nullable = false, length = 50)
    private String firstname;

    @Column(name = "last_name", nullable = false, length = 50)
    private String lastname;

    @Column(name = "Current_Year")
    private Integer currentyear;

    @Column(name = "phone", nullable = false, length = 10, unique = true)
    private String phone;

    @Column(name = "Dob")
    private LocalDate dob;

    @Column(name = "Password_Hash", nullable = false, length = 256)
    // letting password to set as front end is not there
  //  @Getter(AccessLevel.NONE)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String passwordHash;
// remove it when @Setter and @Getter works

    // custom geenrted set and gets
    @Column(name = "parents_first_name", nullable = false, length = 50)
    private String parentsfirstname;

    @Column(name = "parents_last_name", nullable = false, length = 50)
    private String parentslastname;

    @Column(name = "Last_Percentage", precision = 4, scale = 2)
    private BigDecimal lastPercentage;

    @Column(name = "admission_class")
    private Integer adminssionclass;

    @Column(name = "Admission_Year")
    private LocalDate admissionYear;

    @Column(name = "pass_out_class")
    private Integer passoutclass;

    @Column(name = "pass_out_year")
    private LocalDate passoutyear;

    @Column(name = "Aadhar_No", length = 16, nullable = false, unique = true)
    private String aadharNo;

    @Enumerated(EnumType.STRING)
    @Column(name = "Exit_reason")
    private ExitReason exitReason;

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getCurrentyear() {
        return currentyear;
    }

    public void setCurrentyear(Integer currentyear) {
        this.currentyear = currentyear;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getParentsfirstname() {
        return parentsfirstname;
    }

    public void setParentsfirstname(String parentsfirstname) {
        this.parentsfirstname = parentsfirstname;
    }

    public String getParentslastname() {
        return parentslastname;
    }

    public void setParentslastname(String parentslastname) {
        this.parentslastname = parentslastname;
    }

    public BigDecimal getLastPercentage() {
        return lastPercentage;
    }

    public void setLastPercentage(BigDecimal lastPercentage) {
        this.lastPercentage = lastPercentage;
    }

    public Integer getAdminssionclass() {
        return adminssionclass;
    }

    public void setAdminssionclass(Integer adminssionclass) {
        this.adminssionclass = adminssionclass;
    }

    public LocalDate getAdmissionYear() {
        return admissionYear;
    }

    public void setAdmissionYear(LocalDate admissionYear) {
        this.admissionYear = admissionYear;
    }

    public Integer getPassoutclass() {
        return passoutclass;
    }

    public void setPassoutclass(Integer passoutclass) {
        this.passoutclass = passoutclass;
    }

    public LocalDate getPassoutyear() {
        return passoutyear;
    }

    public void setPassoutyear(LocalDate passoutyear) {
        this.passoutyear = passoutyear;
    }

    public String getAadharNo() {
        return aadharNo;
    }

    public void setAadharNo(String aadharNo) {
        this.aadharNo = aadharNo;
    }

    public ExitReason getExitReason() {
        return exitReason;
    }

    public void setExitReason(ExitReason exitReason) {
        this.exitReason = exitReason;
    }

    // remove once lombook works
    @Override
    public String toString() {
        return "Student{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", currentyear=" + currentyear +
                ", phone='" + phone + '\'' +
                ", dob=" + dob +
                ", passwordHash='" + passwordHash + '\'' +
                ", parentsfirstname='" + parentsfirstname + '\'' +
                ", parentslastname='" + parentslastname + '\'' +
                ", lastPercentage=" + lastPercentage +
                ", adminssionclass=" + adminssionclass +
                ", admissionYear=" + admissionYear +
                ", passoutclass=" + passoutclass +
                ", passoutyear=" + passoutyear +
                ", aadharNo='" + aadharNo + '\'' +
                ", exitReason=" + exitReason +
                '}';
    }
}

