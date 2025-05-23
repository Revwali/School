package com.example.Micro_Resource.AsceptConfiguration;

import com.example.Micro_Resource.Entity.User;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class Testspect {


    @Around("execution(* com.example.Micro_Resource.service.UserDbCRUDRepositryService.getUserById(..)) || "+
            "execution(* com.example.Micro_Resource.service.UserDbCRUDRepositryService.getFirstTenUsers(..))")
    public User testspect(ProceedingJoinPoint joinPoint) throws Throwable {
       Object object = joinPoint.proceed();
       if( object != null ){
           return (User) object;
       } else
        return new User();
    }
}
