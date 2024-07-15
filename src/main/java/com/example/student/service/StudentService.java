package com.example.student.service;

import org.springframework.http.ResponseEntity;

import com.example.student.entity.Student;

public interface StudentService {

<<<<<<< HEAD
=======

>>>>>>> 5e38a7dc1098f8d60417182276111e24c9ada5fa
	public ResponseEntity<?> createStudent(Student student);

	public ResponseEntity<?> getStudent();

	public ResponseEntity<?> getById(long id);

	public ResponseEntity<?> updateUser(Student student, long id);

<<<<<<< HEAD
}
=======
	
	public ResponseEntity<?> delete(long id);
	}

>>>>>>> 5e38a7dc1098f8d60417182276111e24c9ada5fa
