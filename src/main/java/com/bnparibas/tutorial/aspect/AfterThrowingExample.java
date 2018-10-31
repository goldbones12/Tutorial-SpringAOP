package com.bnparibas.tutorial.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.web.bind.annotation.RequestMapping;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.aspectj.lang.annotation.AfterThrowing;

@Aspect
public class AfterThrowingExample {

    private static final Logger logger = LoggerFactory.getLogger(AfterThrowingExample.class);

    @Pointcut("within(@org.springframework.web.bind.annotation.RestController *) && @annotation(requestMapping)")
    public void controller(RequestMapping requestMapping) {
    }

    /**
     * This is the method which I would like to execute after a selected method
     * execution throws exception.
     */
    @AfterThrowing(pointcut = "controller(requestMapping)", throwing = "e")
    public void afterThrowing(JoinPoint joinPoint, RequestMapping requestMapping, Throwable e) {
        logger.info(e.getMessage());
     //prints Simulate an error
    }
}
