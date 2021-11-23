package com.cynnox.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cynnox.demo.model.DefaultValue;

@RestController
public class Controller {

	@GetMapping("/default")
	public ResponseEntity<?> getValue(@RequestBody DefaultValue dv ) {
		System.out.println("user endpoint");
		System.out.println(dv);
		return ResponseEntity.ok().body(dv);
	}
	
	
	
	 @RequestMapping(path="/{name}/{age}")
	    public String getMessage(@PathVariable("name") String name, 
	            @PathVariable("age") String age) {
	        
	        var msg = String.format("%s is %s years old", name, age);
	        
	        return msg;
	    }
	 
	 
	
	 @GetMapping("/data1")
	 public String singleParam(@RequestParam String id) {
	   return "id: " + id;
	 }
	 
	 
	
	 @GetMapping("/data2")
	 public String doubleParam(
			 @RequestParam String id,
			 @RequestParam String name
			 ) {
		 String msg = id+name;
	  return msg;
	 } 
	 

	 @GetMapping("/data3")
	 public String handle (@RequestAttribute("visitorCounter") Integer counter) {
	      return String.format("Visitor number: %d", counter);
	 
	 }  
	 
	 
	 
	 
	 
	 
	 
}
