package com.example.Micro_Resource.Enums;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public enum UserScope {

    // firstname,lastname,class
    BASIC("basic"),

    // FULL Student with basic other entities with all details associated
    STUDENT("student"),
    //full teacher and  BASIC other entities plus student + result(last_percentage and result table)
    TEACHER("teacher"),
    //BASIC all entities + finance results + INVOICE
    ACCOUNTANT("accountant"),
    // FUll entities + fess + invoice + results
    PRINCIPAL("principal"),
    // Full entities to save(admission)
    CONTROLLER("controller");

    private final String scopes;

    UserScope(String scopes){
        this.scopes = scopes;
    }

    public String getScopes(){
        return scopes;
    }

    public static UserScope getStudentScope(String scope){
        return UserScope.valueOf(scope);
        }
    }




