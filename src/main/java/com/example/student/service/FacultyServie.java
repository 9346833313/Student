package com.example.student.service;

import org.springframework.http.ResponseEntity;

import com.example.student.Dto.FacultyReqDto;

public interface FacultyServie {

	ResponseEntity<?> createFaculty(FacultyReqDto facultyReqDto);
	
	ResponseEntity<?> updateFaculty(Long id, FacultyReqDto facultyReqDto);
	
	
}
