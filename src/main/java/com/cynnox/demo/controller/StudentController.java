package com.cynnox.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cynnox.demo.model.Student;
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
		return service.findOne(id);
	}

	//method that posts a new user detail   
	//@REQUESTBODY
	@PostMapping("/students/new")
	public void newStudent(@RequestBody Student s) {
		System.out.println("end point");
		Student newStudent = service.save(s);
	}

	//delete a student
	@DeleteMapping("/students/delete/{id}")
	public void deleteStudent(@PathVariable int id) {
		System.out.println("end point");
		Student newStudent = service.deleteOne(id);
	}
	
	


}
