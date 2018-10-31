package com.bnparibas.tutorial.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.web.bind.annotation.RequestMapping;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.aspectj.lang.annotation.AfterReturning; 

@Aspect
 public class AfterReturningExample {

        private static final Logger logger = LoggerFactory.getLogger(AfterReturningExample.class);
        
        @Pointcut("within(@org.springframework.web.bind.annotation.RestController *) && @annotation(requestMapping)")
         public void controller(RequestMapping requestMapping) {}

    /** 
     * This is the method which I would like to execute 
     *  after a selected method execution.
     */ 
         @AfterReturning(pointcut = "controller(requestMapping)", returning = "retVal")
          public void afterReturningAdvice(JoinPoint jp, RequestMapping requestMapping, Object retVal) {
              String returningValue = retVal.toString();
               logger.info("Returning value= {}", returningValue);
              // prints afterReturning advice
           }}
