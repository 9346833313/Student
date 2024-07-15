package com.example.student.service;

import org.springframework.http.ResponseEntity;

import com.example.student.Dto.FacultyReqDto;

public interface FacultyService {

	ResponseEntity<?> createFaculty(FacultyReqDto facultyReqDto);

	// Method to find a faculty member by their ID, returning a ResponseEntity with
	// the faculty member and HTTP status.
	ResponseEntity<?> findFacultyById(Long facultyId);

	ResponseEntity<?> getAllFaculty();

	ResponseEntity<?> updateFaculty(FacultyReqDto facultyReqDto);

	// Method to delete a faculty member by their ID, returning a ResponseEntity
	// indicating the outcome.
	ResponseEntity<?> deleteFacultyId(long id);

}
