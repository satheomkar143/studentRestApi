package com.rest.model;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;
import lombok.Data;

@Document(collection = "student")
@Data
public class Student {
	
	@Id
	private int id;
	private String firstName;
	private String lastName;
	private String mobile;
	private String city;
	private String course;
}
