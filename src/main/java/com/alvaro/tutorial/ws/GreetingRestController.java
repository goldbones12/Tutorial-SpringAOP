package com.alvaro.tutorial.ws;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alvaro.tutorial.aspect.Time;

@RestController
public class GreetingRestController {

	@RequestMapping(value = "/countcows", method = RequestMethod.GET)
	@Time
	public int countcows() {
		List<String> animals = Arrays.asList("cow", "sheep", "dog", "cow");
		return Collections.frequency(animals, "cow");
	}

	@RequestMapping(value = "/greetexception", method = RequestMethod.GET)
	public void greetAfterThrowing() throws Exception {
		throw new Exception("Simulate an error");
	}

	@RequestMapping(value = "/greetafter", method = RequestMethod.GET)
	public String greetAfter() {
		return "afterReturning advice";
	}

	@RequestMapping(value = "/greetprivate", method = RequestMethod.GET)
	private String greetPrivate() {
		return "private advice";
	}

	@RequestMapping(value = "/greetHandling", method = RequestMethod.GET)
	public Integer greetHandling() throws NumberFormatException {
		Integer numberForException = Integer.parseInt("sdasa");
		return numberForException;
	}

}
