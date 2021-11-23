package com.cynnox.demo.model;


public class Student {
	private int id;
	private String name;
	private java.util.Date dob;
	
	public Student(int id, String name, java.util.Date date) {
		super();
		this.id = id;
		this.name = name;
		this.dob = date;
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
