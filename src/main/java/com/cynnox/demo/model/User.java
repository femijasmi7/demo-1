package com.cynnox.demo.model;

import org.springframework.beans.factory.annotation.Value;

public class User {
	private String name;
	private String email;
	@Value("${user.value}")
	private int value;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public User(String name, String email, int value) {
		super();
		this.name = name;
		this.email = email;
		this.value = value;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", email=" + email + ", value=" + value + "]";
	}

}
