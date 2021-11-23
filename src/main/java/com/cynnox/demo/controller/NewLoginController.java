package com.cynnox.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cynnox.demo.model.NewLogin;
import com.cynnox.demo.service.NewLoginService;

@RestController
public class NewLoginController {
	
	@Autowired 
	NewLoginService service;
	
	@GetMapping("/newlogin/all")
	public List<NewLogin> getData() {
		return service.findAll();
	}
	
	@PostMapping("/newlogin/add/new")
	public void newStudent(@RequestBody NewLogin s) {
		System.out.println("end point");
		NewLogin newStudent = service.addNewLogin(s);
	}


}
