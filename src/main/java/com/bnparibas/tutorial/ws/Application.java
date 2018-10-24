package com.bnparibas.tutorial.ws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

import com.bnparibas.tutorial.aspect.ControllerAspect;

@SpringBootApplication
@ComponentScan(basePackageClasses = {GreetingRestController.class,ControllerAspect.class})
public class Application extends SpringBootServletInitializer { 

    public static void main (String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
