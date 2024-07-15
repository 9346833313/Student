package com.example.student.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.student.Dto.FacultyReqDto;
import com.example.student.entity.Faculty;

public interface FacultyService {

	ResponseEntity<?> createFaculty(FacultyReqDto facultyReqDto);

	public Faculty getFacultyById(long id);

	public List<Faculty> getAllFaculty();

	ResponseEntity<?> updateFaculty(FacultyReqDto facultyReqDto);

	public void deleteFacultyById(long id);

}
