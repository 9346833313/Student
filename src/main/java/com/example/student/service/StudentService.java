package com.example.student.service;

import org.springframework.http.ResponseEntity;

import com.example.student.Dto.StudentDTO;

public interface StudentService {

	public ResponseEntity<?> createStudent(StudentDTO studentDTO);

	public ResponseEntity<?> getStudent();

	// Student details get by id - service interface
	public ResponseEntity<?> getById(long id);

	// Student details update by id - service interface
	public ResponseEntity<?> updateUser(StudentDTO studentDto, long id);

	public ResponseEntity<?> delete(long id);

}
