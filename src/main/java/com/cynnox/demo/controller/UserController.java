package com.cynnox.demo.controller;

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
	
	
	@PostMapping("/v1/user/validate")
	public ResponseEntity<?>  validateUser(@Validated
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


//@value
@GetMapping("/v1/user/value")
public ResponseEntity<?>  defaultUser(
		@RequestBody User user) {
	
	System.out.println("User add endpoint");
	return ResponseEntity.ok().body(user);
	
}

}
