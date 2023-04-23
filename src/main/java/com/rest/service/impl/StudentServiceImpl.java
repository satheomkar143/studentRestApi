package com.rest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.rest.exception.StudentNotFound;
import com.rest.model.Student;
import com.rest.payload.ApiResponse;
import com.rest.repository.StudentRepo;
import com.rest.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentRepo studentRepo;

	@Override
	public List<Student> getAllStudents() {
		return studentRepo.findAll();
	}

	@Override
	public Student getStudentById(int id) {
		return studentRepo.findById(id).orElseThrow(() -> new StudentNotFound(id));
	}
	
	@Override
	public Student addStudent(Student student) {
		return studentRepo.save(student);
	}

	@Override
	public Student updateStudentById(int id, Student student) {
		Student oldStudent = studentRepo.findById(id).orElseThrow(() -> new StudentNotFound(id));
		
		if(student.getFirstName() != null) {
			oldStudent.setFirstName(student.getFirstName());
		}
		
		if(student.getLastName() != null) {
			oldStudent.setLastName(student.getLastName());
		}
		
		if(student.getMobile() != null) {
			oldStudent.setMobile(student.getMobile());
		}
		
		if(student.getCity() != null) {
			oldStudent.setCity(student.getCity());
		}
		
		if(student.getCourse()!= null) {
			oldStudent.setCourse(student.getCourse());
		}
		
		return studentRepo.save(oldStudent);
	}

	@Override
	public ApiResponse deleteStudentById(int id) {
		studentRepo.findById(id).orElseThrow(() -> new StudentNotFound(id));	
		studentRepo.deleteById(id);
		
		ApiResponse resp = new ApiResponse("successfully deleted student of id "+ id, HttpStatus.OK);
		return resp;
	}

	

}
