package com.example.Micro_Resource.Entity.Members;

import com.example.Micro_Resource.Entity.User;
import com.example.Micro_Resource.Enums.StudentExitReason;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "student")
public class Student extends User {



    @Column(name = "Current_Year")
    private Integer currentyear;



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




    @Enumerated(EnumType.STRING)
    @Column(name = "Exit_reason")
    private StudentExitReason studentExitReason;






    public Integer getCurrentyear() {
        return currentyear;
    }

    public void setCurrentyear(Integer currentyear) {
        this.currentyear = currentyear;
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



    public StudentExitReason getExitReason() {
        return studentExitReason;
    }

    public void setExitReason(StudentExitReason studentExitReason) {
        this.studentExitReason = studentExitReason;
    }

    // remove once lombook works

}

