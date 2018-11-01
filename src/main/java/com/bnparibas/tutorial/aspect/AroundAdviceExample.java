/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bnparibas.tutorial.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author b35511
 */
public class AroundAdviceExample {
    
    private static final Logger logger = LoggerFactory.getLogger(AroundAdviceExample.class);

    @Pointcut("@annotation(Time)")
     public void timePointcut() {}


       @Around("timePointcut()")
     public Object profileStrategyMethods(ProceedingJoinPoint pjp) throws Throwable {
       long start = System.currentTimeMillis();
       Object value = pjp.proceed();
       long elapsedTime = System.currentTimeMillis() - start;
       logger.info("Method execution time: " + elapsedTime + " milliseconds.");
       return value;
}}
