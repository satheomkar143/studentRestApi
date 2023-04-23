package com.rest.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.rest.model.Student;

public interface StudentRepo extends MongoRepository<Student, Integer>{

}
