package com.cynnox.demo.model;

import java.time.LocalDate;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Student {
	private int id;
//	@NotBlank(message = "Name is mandatory")
	@NotNull
	private String name;
	private Date dob;
	private LocalDate joining;

	
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Student(int id, String name, Date dob, LocalDate joining) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
		this.joining = joining;
	}

	

	public LocalDate getJoining() {
		return joining;
	}


	public void setJoining(LocalDate joining) {
		this.joining = joining;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public java.util.Date getDob() {
		return dob;
	}
	public void setDob(java.util.Date dob) {
		this.dob = dob;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", dob=" + dob + "]";
	}
	
	

}
