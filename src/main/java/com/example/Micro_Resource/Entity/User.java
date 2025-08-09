package com.example.Micro_Resource.Entity;

import com.example.Micro_Resource.Enums.UserScope;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.time.LocalDateTime;


@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "username")
    private String userName;
    @Column(name = "email")
    private String email;
    @Column(name = "phone")
    private String phone;
    @JsonIgnore
    @Column(name = "password")
    private String password;
    @Column(name = "created_at")
    private LocalDateTime created_at;
    @JsonIgnore
    @Column(name = "scope")
    private UserScope userScope;

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

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
