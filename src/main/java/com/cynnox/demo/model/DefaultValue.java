package com.cynnox.demo.model;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;

public class DefaultValue {
	@Value(value = "10")
	private int value;
	
	@DateTimeFormat(pattern = "MM-dd-yyyy")
	@Value(value = "${def.date}")
	private Date dateOfBirth;

	public DefaultValue(int value, Date dateOfBirth) {
		super();
		this.value = value;
		this.dateOfBirth = dateOfBirth;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public DefaultValue() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DefaultValue(int value) {
		super();
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "DefaultValue [value=" + value + ", dateOfBirth=" + dateOfBirth + "]";
	}
	

}
