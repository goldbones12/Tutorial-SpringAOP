package com.alvaro.tutorial.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class HandlingExceptionExample {

	private static final Logger log = LoggerFactory.getLogger(HandlingExceptionExample.class);

	@Pointcut("within(@org.springframework.web.bind.annotation.RestController *) && execution(* com.alvaro.tutorial.ws.GreetingRestController.greetHandling(..))")
	public void controller() {
	}

	@Around("controller()")
	public Object profileStrategyMethods(ProceedingJoinPoint pjp) throws Throwable {

		Object output = null;
		try {
			output = pjp.proceed();
		} catch (Throwable t) {
			log.info(t.getMessage());
		}

		return output;
	}

}
