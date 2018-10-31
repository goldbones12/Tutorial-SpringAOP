package com.bnparibas.tutorial.ws;

import com.bnparibas.tutorial.aspect.Time;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
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

}
