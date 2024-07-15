package com.example.student.service;

import org.springframework.http.ResponseEntity;

import com.example.student.Dto.StudentDTO;
import com.example.student.entity.Student;

public interface StudentService {


	public ResponseEntity<?> createStudent(StudentDTO studentDTO);

	public ResponseEntity<?> getStudent();

	public ResponseEntity<?> getById(long id);

	public ResponseEntity<?> updateUser(Student student, long id);


	public ResponseEntity<?> delete(long id);



}

