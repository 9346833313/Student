package com.example.student.service;

import org.springframework.http.ResponseEntity;

import com.example.student.entity.Student;

public interface StudentService {
<<<<<<< HEAD
	public ResponseEntity<?> createStudent(Student student);

	public ResponseEntity<?> getStudent();
=======
	public ResponseEntity<?> getById(long id);

	public ResponseEntity<?> updateUser(Student student, long id);
>>>>>>> 9ee139ddce02409ddcee7f6a37a9e7b198bb90b6
}
