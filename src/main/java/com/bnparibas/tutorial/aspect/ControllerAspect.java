package com.bnparibas.tutorial.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Aspect
@EnableAspectJAutoProxy
@Component
public class ControllerAspect {

	private static final Logger log = LoggerFactory.getLogger(ControllerAspect.class);
	 
   @Pointcut("within(@org.springframework.web.bind.annotation.RestController *) && @annotation(requestMapping)")
	public void controller(RequestMapping requestMapping) {
	}

	@Before("controller(requestMapping)")
	public void advice(JoinPoint thisJoinPoint, RequestMapping requestMapping) {
		log.info("Logging request mapping");

		// do whatever you want with the value
	}

	@Around("@annotation(loggable)")
	public Object myAdvice(ProceedingJoinPoint pjp, Loggable loggable) throws Throwable {
		log.debug("Executing myAdvice!! - Begin");
		Object returnValue = null;

		log.debug("Start method execution");
		returnValue = pjp.proceed(); // this will execute the annotated method
		log.debug("After method execution");
		return returnValue;
	}
}
