package com.example.student.service;

import org.springframework.http.ResponseEntity;

import com.example.student.Dto.StudentDTO;
import com.example.student.ResDto.ResponseDto;
import com.example.student.entity.Student;

public interface StudentService {

	public ResponseEntity<?> createStudent(Student student);

	public ResponseEntity<?> getStudent();
	// Student details get by id - serviceImpl
	public ResponseEntity<ResponseDto> getById(long id);
	// Student details update by id - serviceImpl
	public ResponseEntity<ResponseDto> updateUser(StudentDTO studentDto, long id);

	public ResponseEntity<?> delete(long id);

}
