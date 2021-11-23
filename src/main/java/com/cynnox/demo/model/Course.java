package com.cynnox.demo.model;

public class Course {
	private String name;
	private long fee;
	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Course(String name, long fee) {
		super();
		this.name = name;
		this.fee = fee;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getFee() {
		return fee;
	}
	public void setFee(long fee) {
		this.fee = fee;
	}
	@Override
	public String toString() {
		return "Course [name=" + name + ", fee=" + fee + "]";
	}
	
	


}
