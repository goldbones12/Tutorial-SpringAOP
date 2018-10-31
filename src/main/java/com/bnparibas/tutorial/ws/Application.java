package com.bnparibas.tutorial.ws;

import com.bnparibas.tutorial.aspect.AfterReturningExample;
import com.bnparibas.tutorial.aspect.AfterThrowingExample;
import com.bnparibas.tutorial.aspect.AroundAdviceExample;
import com.bnparibas.tutorial.aspect.BeforeExample;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackageClasses = {GreetingRestController.class,AfterReturningExample.class,AfterThrowingExample.class,AroundAdviceExample.class,BeforeExample.class})
public class Application extends SpringBootServletInitializer { 

    public static void main (String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
