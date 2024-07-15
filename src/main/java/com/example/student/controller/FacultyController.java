package com.example.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.student.Dto.FacultyReqDto;
import com.example.student.entity.Faculty;
import com.example.student.service.FacultyService;

@RestController
@RequestMapping("/Faculty")
public class FacultyController {
	@Autowired
	private FacultyService facultyService;

	@PostMapping("faculty/create")
	ResponseEntity<?> createFaculty(FacultyReqDto facultyReqDto) {
		return facultyService.createFaculty(facultyReqDto);

	}

	@GetMapping("faculty/{id}")
	public ResponseEntity<Faculty> getFacultyId(@PathVariable("id") Long facultyId) {
		Faculty faculty = facultyService.getFacultyById(facultyId);
		return new ResponseEntity<>(faculty, HttpStatus.OK);

	}

	@GetMapping("/faculty")
	public ResponseEntity<List<Faculty>> getAllFaculty() {
		List<Faculty> list = facultyService.getAllFaculty();
		return new ResponseEntity<List<Faculty>>(list, HttpStatus.OK);

	}

	@PostMapping("faculty/{id}")
	ResponseEntity<?> updateFaculty(Long id, FacultyReqDto facultyReqDto) {
		return facultyService.updateFaculty(id, facultyReqDto);

	}

	@DeleteMapping("faculty/{id}")
	public ResponseEntity<String> deleteFaculty(@PathVariable("id") Long facultyId) {
		facultyService.deleteFacultyById(facultyId);
		return new ResponseEntity<>("Faculty Id successfully deleted!", HttpStatus.OK);
	}

}
