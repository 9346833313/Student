package com.example.student.controller;

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

import com.example.student.entity.Student;
import com.example.student.service.StudentService;

@RequestMapping("/api/students")
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

	@GetMapping("{id}")
	public ResponseEntity<?> getById(@PathVariable long id) {
		return studentService.getById(id);
	}

	@PutMapping("{id}")
	public ResponseEntity<?> updateUser(@RequestBody Student student, @PathVariable long id) {
		return studentService.updateUser(student, id);

	}

	@DeleteMapping("{id}")
	public ResponseEntity<?> delete(@PathVariable long id) {
		return studentService.delete(id);

	}

}
