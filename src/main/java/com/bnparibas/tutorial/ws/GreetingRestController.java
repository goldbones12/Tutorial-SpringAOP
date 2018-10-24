package com.bnparibas.tutorial.ws;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingRestController {

	/**
	 * @return String representing the greeting
	 */
	@RequestMapping(value = "/greet", method = RequestMethod.GET)
	public String greet() {
		return "greet";
	}
	
	@RequestMapping("/")
    public String welcome() {//Welcome page, non-rest
        return "Welcome to RestTemplate Example.";
    }
}
