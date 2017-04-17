package com.mitrais.train.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @RequestMapping(value="/hello", method=RequestMethod.GET)
    @ResponseBody
    public String getHello(@RequestParam(value = "message", defaultValue = "Hello Spring")
    String message) {
    	return "This is Get Hello, Your message: " + message;
    }
	
    @RequestMapping(value="/hello", method=RequestMethod.POST)
    @ResponseBody
    public String postHello(@RequestBody String message) {
    	return "This is Post Hello, Your message: " + message;
    }
	
    @RequestMapping(value="/hello/{message}", method=RequestMethod.PUT)
    @ResponseBody
    public String putHello(@PathVariable String message) {
    	return "This is Put Hello, Your message: " + message;
    }
}
