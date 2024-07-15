package com.example.student.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.student.Dto.FacultyReqDto;
import com.example.student.entity.Faculty;

public interface FacultyService {

	ResponseEntity<?> createFaculty(FacultyReqDto facultyReqDto);

	ResponseEntity<?> updateFaculty(Long id, FacultyReqDto facultyReqDto);

	public List<Faculty> getAllFaculty();

	public Faculty getFacultyById(long id);

	public void deleteFacultyById(long id);

}
