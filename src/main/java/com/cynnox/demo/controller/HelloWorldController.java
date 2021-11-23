package com.cynnox.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cynnox.demo.model.HelloWorldBean;

@RestController
public class HelloWorldController {
	
	//REQUESTMAPPING
	@RequestMapping(method=RequestMethod.GET, path="/hello-world")  
	public String helloWorld()  
	{  
	return "Hello World";  
	}  
	
	
	//GETMAPPING
	@GetMapping(path="/hello-world-bean")  
	public HelloWorldBean helloWorldBean()  
	{  
	return new HelloWorldBean("Hello"); //constructor of HelloWorldBean  
	}  
	
	
	
	
	
	
}
