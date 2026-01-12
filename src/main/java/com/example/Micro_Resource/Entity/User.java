package com.example.Micro_Resource.Entity;

import com.example.Micro_Resource.Enums.UserScope;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Setter;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.time.LocalDate;
import java.time.LocalDateTime;
@MappedSuperclass
/*
@Entity
@Table(name = "user")*/
public abstract class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "first_name", nullable = false, length = 50)
    private String firstname;

    @Column(name = "last_name", nullable = false, length = 50)
    private String lastname;

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

    @Column(name = "Aadhar_No", length = 16, nullable = false, unique = true)
    private String aadharNo;

    @Column(name = "email")
    private String email;

    @JsonIgnore
    @Column(name = "roles")
    private UserScope userScope;
    @Column(name = "is_associate")
    private boolean is_associate;

    public String getAadharNo() {
        return aadharNo;
    }

    public void setAadharNo(String aadharNo) {
        this.aadharNo = aadharNo;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
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

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public UserScope getUserScope() {
        return userScope;
    }

    public void setUserScope(UserScope userScope) {
        this.userScope = userScope;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getEmail() {
        return email;
    }


    public boolean isIs_associate() {
        return is_associate;
    }

    public void setIs_associate(boolean is_associate) {
        this.is_associate = is_associate;
    }
}
