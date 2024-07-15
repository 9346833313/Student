package com.example.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.student.entity.Student;
import com.example.student.service.StudentService;

@RequestMapping
@RestController
public class StudentController {
	@Autowired
	private StudentService studentService;

	@PostMapping
	public ResponseEntity<?> save(@RequestBody Student student) {
		return studentService.createStudent(student);
	}
	@GetMapping
	public ResponseEntity<?> getAllStudents() {
		return studentService.getStudent();
	}
}
