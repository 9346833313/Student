package com.example.student.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.student.entity.Student;
import com.example.student.repository.StudentRepo;
import com.example.student.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentRepo studentRepo;

	@Override
	public ResponseEntity<?> createStudent(Student student) {

		return new ResponseEntity<>(studentRepo.save(student), HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<?> getStudent() {

		return new ResponseEntity<>(studentRepo.findAll(), HttpStatus.OK);
	}

}
