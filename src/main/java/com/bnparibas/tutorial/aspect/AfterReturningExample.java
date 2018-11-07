package com.bnparibas.tutorial.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AfterReturningExample {

	private static final Logger logger = LoggerFactory.getLogger(AfterReturningExample.class);

	@Pointcut("execution(* com.bnparibas.tutorial.ws.GreetingRestController.greetAfter(..))")
	public void controller() {
	}

	/**
	 * This is the method which I would like to execute after a selected method
	 * execution.
	 */
	@AfterReturning(pointcut = "lel()", returning = "pipoca")
	public void afterReturningAdvice(JoinPoint jp, Object pipoca) {
		String returningValue = pipoca.toString();
		logger.info("Returning value= {}", returningValue);
		// prints afterReturning advice
	}
	
	
	@Pointcut("execution(* greetAfter(..))")
	public void lel() {
	}
}
