package com.cynnox.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cynnox.demo.model.Student;
import com.cynnox.demo.model.UserNotFoundException;
import com.cynnox.demo.service.StudentService;

@RestController
public class StudentController {
    
	//@AUTOWIRED
	@Autowired  
	private StudentService service;  
	
	//@GETMAPPING
	@GetMapping("/students")  
	public List<Student> retriveAllUsers()  
	{  
	return service.findAll();  
	}  
	
	//retrieves a specific student detail  
	//@PATHVARIABLE
	@GetMapping("/students/find/{id}")
	public Student retrieveStudent(@PathVariable("id") int id){
		Student std = service.findOne(id);
		if(std == null) {
			throw new UserNotFoundException("id: "+id);
		}
		return std;
	}

	//method that posts a new student detail   
	//@REQUESTBODY
	@PostMapping("/students/new")
	public void newStudent(@Valid @RequestBody Student s) {
		System.out.println("end point");
		Student newStudent = service.addStudent(s);
	}

	//delete a student
	@DeleteMapping("/students/delete/{id}")
	public void deleteStudent(@PathVariable int id) {
		System.out.println("end point");
		Student newStudent = service.deleteOne(id);
	}
	
	//modelattribute
//	@GetMapping


}
