package com.cynnox.demo.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cynnox.demo.model.Student;

@Service  
public class StudentService {
	public static int stdCount=5; 
	
	private static List<Student> students=new ArrayList<>();  
	static LocalDateTime now = LocalDateTime.now();
	private void syso() {
		System.out.println(now);
	}

	static  
	{  
	//adding users to the list  
		students.add(new Student(1, "John",  new Date()));  
		students.add(new Student(2, "Robert",  new Date()));  
		students.add(new Student(3, "Adam",  new Date()));  
		students.add(new Student(4, "Andrew",  new Date()));  
		students.add(new Student(5, "Jack",  new Date()));  
	}  
	
	//method that retrieve all students from the list  
	public List<Student> findAll()  
	{  
		syso();
	return students; 
	}  
	
	//method that add the students in the list   
	public Student save(Student s)  
	{  
	if(s.getId() == 0)  
	{  
	//increments the id  
	s.setId(++stdCount);  
	}  
	students.add(s);  
	return s;  
	}  
	
	//find student
	public Student findOne(int id) {
		for(Student i : students) {
			if(i.getId() == id) {
				return i;
			}
		}
		return null;
	}
	
	//delete student
	public Student deleteOne(int id) {
		Iterator<Student> i = students.iterator();
		while(i.hasNext()) {
			Student student = i.next();
			if(student.getId() == id) {
				i.remove();
				return student;
			}
		}
		return null;
	}
	
	

}
