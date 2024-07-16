package com.example.student.service;

import org.springframework.http.ResponseEntity;

import com.example.student.Dto.StudentDTO;

/**
 * Service interface for Student CRUD operations.
 */
public interface StudentService {

	public ResponseEntity<?> createStudent(StudentDTO studentDTO);

	public ResponseEntity<?> getStudent();


	public ResponseEntity<?> getById(long id);

	
	public ResponseEntity<?> updateUser(StudentDTO studentDto, long id);

	public ResponseEntity<?> delete(long id);

}
