package com.cynnox.demo.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.lang.NonNull;

public class UserReq {
//	  @NonNull(message = "Name cannot be null")
	@Value(value = "femisha")
	private String name;
	@NonNull
	private String email;
	@NonNull
	private String password;

	public UserReq() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserReq(String name, String email, String password) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserReq [name=" + name + ", email=" + email + ", password=" + password + "]";
	}

}
