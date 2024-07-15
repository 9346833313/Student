package com.example.student.service;

import org.springframework.http.ResponseEntity;

import com.example.student.Dto.StudentDTO;

import com.example.student.ResDto.ResponseDto;




public interface StudentService {


	public ResponseEntity<?> createStudent(StudentDTO studentDTO);


	public ResponseEntity<?> getStudent();

	// Student details get by id - service interface
	public ResponseEntity<ResponseDto> getById(long id);

	// Student details update by id - service interface
	public ResponseEntity<ResponseDto> updateUser(StudentDTO studentDto, long id);

	public ResponseEntity<?> delete(long id);

}
