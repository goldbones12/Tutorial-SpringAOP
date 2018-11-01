package com.bnparibas.tutorial.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
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

	@Pointcut("@annotation(Time)")
	public void timePointcut() {
	}

	@Around("timePointcut()")
	public Object profileStrategyMethods(ProceedingJoinPoint pjp) throws Throwable {

		long start = System.currentTimeMillis();
		Object value = pjp.proceed();
		long elapsedTime = System.currentTimeMillis() - start;
		log.info("Method execution time: " + elapsedTime + " milliseconds.");
		return value;
	}

}
