package com.cynnox.demo.model;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;

public class NewLogin {
private int id;
private String name;
private LocalDateTime join;
private Object course;
private Object[] education;



public NewLogin() {
	super();
	// TODO Auto-generated constructor stub
}


public NewLogin(int id, String name, LocalDateTime join, Object course, Object[] education) {
	super();
	this.id = id;
	this.name = name;
	this.join = join;
	this.course = course;
	this.education = education;
}



public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Object getCourse() {
	return course;
}
public void setCourse(Object course) {
	this.course = course;
}


public Object[] getEducation() {
	return education;
}


public void setEducation(Object[] education) {
	this.education = education;
}


public LocalDateTime getJoin() {
	return join;
}


public void setJoin(LocalDateTime join) {
	this.join = join;
}


public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}



@Override
public String toString() {
	return "NewLogin [id=" + id + ", name=" + name + ", course=" + course + ", education=" + Arrays.toString(education)
			+ ", join=" + join + "]";
}



}
