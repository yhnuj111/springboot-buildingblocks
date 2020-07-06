package com.stacksimplify.restservices.Hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

// Controller
@RestController
public class HelloWorldController {
	
	// Simple Method
	// URL -/hello-world
	// GET
	@RequestMapping(method=RequestMethod.GET, path = "/hello-world")
	public String HelloWorld() {
		return "Hello World";
	}
}
