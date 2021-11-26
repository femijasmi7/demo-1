package com.cynnox.demo.mdb.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.cynnox.demo.model.Tutorial;

public interface TutorialRepository extends MongoRepository<Tutorial, String>{
	 List<Tutorial> findByTitleContaining(String title);
	  List<Tutorial> findByPublished(boolean published);
	 
}
