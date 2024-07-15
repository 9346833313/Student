package com.example.student.service;

import org.springframework.http.ResponseEntity;

import com.example.student.Dto.FacultyReqDto;

public interface FacultyService {

	ResponseEntity<?> createFaculty(FacultyReqDto facultyReqDto);

	ResponseEntity<?> findFacultyById(Long facultyId);

	ResponseEntity<?> getAllFaculty();

	ResponseEntity<?> updateFaculty(FacultyReqDto facultyReqDto);

	ResponseEntity<?> deleteFacultyId(long id);

}
