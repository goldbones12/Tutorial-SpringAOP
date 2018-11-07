package com.bnparibas.tutorial.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Aspect
@Component
@EnableAspectJAutoProxy
public class PrivateAspect {

	private static final Logger log = LoggerFactory.getLogger(PrivateAspect.class);
	 
   @Pointcut("within(@org.springframework.web.bind.annotation.RestController *) && execution(* com.bnparibas.tutorial.ws.GreetingRestController.greetPrivate(..))")
	public void controller() {
	}

	@Before("controller()")
	public void advice(JoinPoint jointPoint) {
		//Spring AOP dont advice private methods
		log.info("IS NOT GOING TO LOG");
	}
	
	


}
