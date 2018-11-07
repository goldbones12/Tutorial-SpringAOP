package com.bnparibas.tutorial.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Aspect
@EnableAspectJAutoProxy(proxyTargetClass=true )
public class BeforeExample {

    //private Logger logger = LoggerFactory.getLogger(MyAspect.class.getName());
    private static final Logger logger = LoggerFactory.getLogger(BeforeExample.class);

    @Pointcut("within(@org.springframework.web.bind.annotation.RestController *) && @annotation(org.springframework.web.bind.annotation.GetMapping)")
    public void controller(GetMapping getMapping) {
    }
    
    @Pointcut("execution(@(@org.springframework.web.bind.annotation.RequestMapping *) * *(..))")
    public void requestMappingAnnotations() { }
    
    @Pointcut("within(@(@GetMapping *) *)")
    public void lel(GetMapping getMapping) {}
 
    /**
     * This advice, as the name implies, is executed before the join point. It
     * does not prevent the continued execution of the method it advises unless
     * an exception is thrown.
     */
    @Before("lel(getMapping)")
    public void logMethodCall(JoinPoint joinPoint, GetMapping getMapping) {
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getTarget().getClass().getCanonicalName();
        String[] values = getMapping.value();
        logger.info("Method name={}, Class Name= {}  value= {}", methodName, className, values[0]);
    }
    
    @Before("requestMappingAnnotations()")
    public void logMethodCalal(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getTarget().getClass().getCanonicalName();
        logger.info("Method name={}, Class Name= {}  value= {}", methodName, className,className);
    }
}
