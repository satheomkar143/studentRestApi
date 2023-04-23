package com.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.model.Student;
import com.rest.payload.ApiResponse;
import com.rest.service.impl.StudentServiceImpl;

@RestController
@RequestMapping("/api/student")
public class StudentController {
	
	@Autowired
	private StudentServiceImpl studentServiceImpl;
	
	
//	add new student
	@PostMapping
	public ResponseEntity<Student> saveStudent(@RequestBody Student student){
		return ResponseEntity.ok(studentServiceImpl.addStudent(student));
	}
	
//	get all students
	@GetMapping
	public ResponseEntity<List<Student>> getAllStudents(){
		return ResponseEntity.ok(studentServiceImpl.getAllStudents());
	}
	
//	get student by id
	@GetMapping("{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable int id){
		return ResponseEntity.ok(studentServiceImpl.getStudentById(id));
	}
	
//	update student by id
	@PutMapping("{id}")
	public ResponseEntity<Student> updateStudentById(@PathVariable int id, @RequestBody Student student){	
		return ResponseEntity.ok(studentServiceImpl.updateStudentById(id, student));	
	}
	
//	delete student by id
	@DeleteMapping("{id}")
	public ResponseEntity<ApiResponse> deleteStudentById(@PathVariable int id){
		return ResponseEntity.ok(studentServiceImpl.deleteStudentById(id));
	}
	
	
}
