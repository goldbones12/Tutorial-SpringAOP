package com.alvaro.tutorial.ws;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class BeforeController {

	
	/**
	 * @return String representing the greeting
	 * @throws Exception 
	 */
	@RequestMapping(value = "/beforeexception", method = RequestMethod.GET)
	public void beforeException() throws Exception {
		throw new Exception("Just an exception");
	}
	

	/**
	 * @return String representing the greeting
	 */
	@RequestMapping(value = "/beforeexample", method = RequestMethod.GET)
	public String beforeExample() {
		return "greet";
	}
	

	
	
	
	

}
