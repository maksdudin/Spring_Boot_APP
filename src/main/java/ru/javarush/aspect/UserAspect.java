//package com.javarush.aspect;
//
//import java.util.Arrays;
//import java.util.stream.Collectors;
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.After;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.aspectj.lang.annotation.Pointcut;
//import org.springframework.stereotype.Component;
//
//@Aspect
//@Component
//public class UserAspect {
//
//    @Pointcut("within(com.javarush.service.*)")  // save, getById, deleteById
//    public void allMethodsPointcut(){}
//
//    @Pointcut("execution(public * com.javarush.service.UserService.saveUser(..))")
//    public void callAllMyServicePublic(){} /// save
//
//    @Before("allMethodsPointcut()")
//    public void loggingAdvice(){
//        System.out.println("executing before method invoke");
//    }
//
//    @Before("callAllMyServicePublic()")
//    public void beforeCallAtMethod(JoinPoint jp){
//        String args= Arrays.stream(jp.getArgs())
//                .map(Object::toString)
//                .collect(Collectors.joining(","));
//        System.out.println("before "+jp+", args=["+args+"]");
//    }
//
//    @After("callAllMyServicePublic()")
//    public void afterCallAt(JoinPoint jp){
//        System.out.println("after "+jp.getSignature().getName());
//    }
//
//    @Around("within(com.javarush.service.*)") //deleteById,getById
//    public void aroundAdvice(ProceedingJoinPoint joinPoint){
//        System.out.println("Before invoking method"+joinPoint.getSignature());
//
//        Object value=null;
//        try{
//            value=joinPoint.proceed();
//        }catch (Throwable e){
//            e.printStackTrace();
//        }
//
//        System.out.println("After invoking method. Retune value="+value);
//    }
//
//}