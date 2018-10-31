package com.bnparibas.tutorial.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;

@Aspect
public class BeforeExample {

    //private Logger logger = LoggerFactory.getLogger(MyAspect.class.getName());
    private static final Logger logger = LoggerFactory.getLogger(BeforeExample.class);

    @Pointcut("within(@org.springframework.web.bind.annotation.RestController *) && @annotation(requestMapping)")
    public void controller(RequestMapping requestMapping) {
    }

    /**
     * This advice, as the name implies, is executed before the join point. It
     * does not prevent the continued execution of the method it advises unless
     * an exception is thrown.
     */
    @Before("controller(requestMapping)")
    public void logMethodCall(JoinPoint joinPoint, RequestMapping requestMapping) {
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getTarget().getClass().getCanonicalName();
        String[] values = requestMapping.value();
        logger.info("Method name={}, Class Name= {}  value= {}", methodName, className, values[0]);
    }
}
