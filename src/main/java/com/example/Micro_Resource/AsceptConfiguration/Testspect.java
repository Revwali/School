package com.example.Micro_Resource.AsceptConfiguration;

import com.example.Micro_Resource.Entity.User;
import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

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

    @Before("execution(* com.example.Micro_Resource.service.StudentService.java) ||"
            +" execution(* com.example.Micro_Resource.controller.StudentController.java)"
    )
    public void getStudentBeforeAscpect(HttpServletRequest request){

        System.out.println(request.getAttribute("Username")+" and "+request.getAttribute("Passsword"));
    }
    @After("execution(* com.example.Micro_Resource.service.StudentService.java)")
    public void getStudentAfterAscpect(){
        System.out.println("after srvice is invoked");
    }
}
