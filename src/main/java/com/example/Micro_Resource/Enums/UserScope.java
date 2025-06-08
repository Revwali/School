package com.example.Micro_Resource.Enums;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public enum UserScope {

    // firstname,lastname,class
    BASIC("basic"),

    // FULL Student with all details associated
    STUDENT("student"),
   // BASIC + result(last_percentage and result table)
    TEACHER("teacher"),
    //BASIC + Fees(full history) + INVOICE
    ACCOUNTANT("accountant"),
    // FUll studnet + fess + invoice + results
    PRINCIPAL("principal"),
    // Full Student to save(admission)
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




