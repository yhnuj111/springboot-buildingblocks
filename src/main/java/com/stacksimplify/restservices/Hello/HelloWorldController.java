package com.stacksimplify.restservices.Hello;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

// Controller
@RestController
public class HelloWorldController {

	@Autowired
	private ResourceBundleMessageSource messageSource;

	// Simple Method
	// URL -/hello-world
	// GET
	// @RequestMapping(method=RequestMethod.GET, path = "/hello-world")
	@GetMapping("/hello-world1")
	public String HelloWorld() {
		return "Hello World";
	}

	@GetMapping("/helloWorld-bean")
	public UserDetail helloWorldBean() {
		return new UserDetail("Zhehang", "Xu", "Shanghai");
	}

	@GetMapping("/hello-init")
	public String getMessagesInI18NFormat(@RequestHeader(name = "Accept-Language", required = false) String locale) {
		return messageSource.getMessage("label.hello", null, new Locale(locale));
	}
	
	@GetMapping("/hello-init2")
	public String getMessagesInI18NFormat2() {
		return messageSource.getMessage("label.hello", null, LocaleContextHolder.getLocale());
	}
}
