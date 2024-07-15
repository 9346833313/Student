package com.example.student.service;

import org.springframework.http.ResponseEntity;

import com.example.student.entity.Student;

public interface StudentService {
<<<<<<< HEAD
	public ResponseEntity<?> createStudent(Student student);

	public ResponseEntity<?> getStudent();
	public ResponseEntity<?> getById(long id);

	public ResponseEntity<?> updateUser(Student student, long id);
}
=======

	public ResponseEntity<?> createStudent(Student student);

	public ResponseEntity<?> getStudent();

	public ResponseEntity<?> getById(long id);

	public ResponseEntity<?> updateUser(Student student, long id);

	
	public ResponseEntity<?> delete(long id);
	}

>>>>>>> 2ba2b6255f33d33f92e6533a6ed0e7698c6dfcd4
