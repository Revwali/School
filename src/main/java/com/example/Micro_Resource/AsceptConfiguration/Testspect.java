package com.example.Micro_Resource.AsceptConfiguration;

import com.example.Micro_Resource.Entity.User;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class Testspect {

/*
    @Around("execution(* com.example.Micro_Resource.service.UserDbCRUDRepositryService.getUserById(..)) || "+
            "execution(* com.example.Micro_Resource.service.UserDbCRUDRepositryService.getFirstTenUsers(..)) ||"+
            "execution(* com.example.Micro_Resource.service.StudentService.java)")
    public User testspect(ProceedingJoinPoint joinPoint) throws Throwable {
       Object object = joinPoint.proceed();
       if( object != null ){
           return (User) object;
       } else
        return new User();
    }*/

    @Before("execution(* com.example.Micro_Resource.service.StudentService.java)")
    public void getStudentBeforeAscpect(){
        System.out.println("before srvice is invoked");
    }
    @After("execution(* com.example.Micro_Resource.service.StudentService.java)")
    public void getStudentAfterAscpect(){
        System.out.println("after srvice is invoked");
    }
}
