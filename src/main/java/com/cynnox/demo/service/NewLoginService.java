package com.cynnox.demo.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cynnox.demo.model.Course;
import com.cynnox.demo.model.Education;
import com.cynnox.demo.model.NewLogin;

@Service
public class NewLoginService {
	private static List <NewLogin> logins = new ArrayList<NewLogin>();
	private static List <Course> course = new ArrayList<Course>();
	private static int id = 4;
	
	private static List <Education> edu = new ArrayList<Education>();
	private static Object[] education = {edu};
	
	private static LocalDate date = LocalDate.of(2021, 04, 24);
	private static LocalTime time = LocalTime.of(10, 34);
	private static LocalDateTime join = LocalDateTime.of(date, time);
	
   
   //set education 
   static {
	  edu.add(new Education("btech"));
	  edu.add(new Education("mtech"));
   }
   
   
   //add course to list
	static {
		course.add(new Course("java", 2000));
		course.add(new Course("python", 1000));
		course.add(new Course("android", 1500));
	}

	//add users to list
	static {
		logins.add(new NewLogin(1, "james", join,course, education));
	}
	
	//get all users
	public List<NewLogin> findAll() {
		return logins;
	}
	
	//add new users
	public NewLogin addNewLogin(NewLogin nl) {
		if(nl.getId() == 0)  
		{  
		//increments the id  
		nl.setId(++id);  
		}  
		logins.add(nl);
		return nl;
		
	}
	

}
