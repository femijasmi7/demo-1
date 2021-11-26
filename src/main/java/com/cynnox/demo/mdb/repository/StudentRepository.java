package com.cynnox.demo.mdb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cynnox.demo.model.Student;

public interface StudentRepository extends MongoRepository<Student, String>{
	

}
