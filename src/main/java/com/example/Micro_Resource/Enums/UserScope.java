package com.example.Micro_Resource.Enums;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public enum UserScope {

    // firstname,lastname,class
    BASIC("basic",1),

    // FULL Student with basic other entities with all details associated
    STUDENT("student",2),
    //full teacher and  BASIC other entities plus student + result(last_percentage and result table)
        TEACHER("teacher",2),
    //Full Accountant BASIC all entities + finance results + INVOICE
        ACCOUNTANT("accountant",2),
    // FUll entities + fess + invoice + results
    PRINCIPAL("principal",2),
    // Full entities to save(admission)
    CONTROLLER("controller",2);

    private final String scopes;
    private final int grade;

    public int getGrade() {
        return grade;
    }

    UserScope(String scopes, int grade){
        this.scopes = scopes;
        this.grade = grade;
    }

    public String getScopes(){
        return scopes;
    }

    public static UserScope getStudentScope(String scope){
        return UserScope.valueOf(scope);
        }
    }




