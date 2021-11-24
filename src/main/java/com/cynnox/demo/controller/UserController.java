package com.cynnox.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cynnox.demo.model.User;
import com.cynnox.demo.model.UserReq;

@RestController
public class UserController {
	
	@GetMapping("/v1/user")
	public ResponseEntity<?>  getUser() {
		System.out.println("User endpoint");
		User user = new User("femisha","femisha@");
		return ResponseEntity.ok().body(user);
	}
	
	@PostMapping("/v1/user/add")
	public ResponseEntity<?>  addUser(@RequestBody UserReq req) {
		System.out.println("User add endpoint");
		System.out.println(req);
		return ResponseEntity.ok().body(req);
	}

	
//validate user	
	@PostMapping("/v1/user/validate")
	public ResponseEntity<?>  validateUser(@Value(value = "")
			@RequestBody UserReq req) {
		System.out.println("User add endpoint");
		System.out.println(req);
		return ResponseEntity.ok().body(req);
	}
	

@RequestMapping("/user")
public ResponseEntity<?>  getUser(@Validated
		@RequestBody UserReq req) {
	System.out.println("User add endpoint");
	System.out.println(req);
	return ResponseEntity.ok().body(req);
}
	

@PutMapping("/v1/user/update")
public ResponseEntity<?>  udateUser(
		@RequestBody UserReq req) {
	System.out.println("User add endpoint");
	System.out.println(req);
	return ResponseEntity.ok().body(req);
	
}



}
