package com.rest.service;

import java.util.List;

import com.rest.model.Student;
import com.rest.payload.ApiResponse;

public interface StudentService {
	
	List<Student> getAllStudents();
	
	Student getStudentById(int id);
	
	Student addStudent(Student student);
	
	Student updateStudentById(int id, Student student);
	
	ApiResponse deleteStudentById(int id);

}
