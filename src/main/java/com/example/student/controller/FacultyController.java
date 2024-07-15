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
import com.example.student.service.FacultyServie;

@RestController
@RequestMapping("/Faculty")
public class FacultyController {
	@Autowired
	private FacultyServie facultyServie;

	@GetMapping("faculty/{id}")
	public ResponseEntity<Faculty> getFacultyId(@PathVariable("id") Long facultyId) {
		Faculty faculty = facultyServie.getFacultyById(facultyId);
		return new ResponseEntity<>(faculty, HttpStatus.OK);

	}

	@GetMapping("/faculty")
	public ResponseEntity<List<Faculty>> getAllFaculty() {
		List<Faculty> list = facultyServie.getAllFaculty();
		return new ResponseEntity<List<Faculty>>(list, HttpStatus.OK);

	}

	@DeleteMapping("staff/{id}")
	public ResponseEntity<String> deleteFaculty(@PathVariable("id") Long facultyId) {
		facultyServie.deleteFacultyById(facultyId);
		return new ResponseEntity<>("Faculty Id successfully deleted!", HttpStatus.OK);
	}
	
	@PostMapping("faculty/create")
	ResponseEntity<?> createFaculty(FacultyReqDto facultyReqDto){
		return facultyServie.createFaculty(facultyReqDto);
		
	}
	
	@PostMapping("faculty/{id}")
	ResponseEntity<?> updateFaculty(Long id, FacultyReqDto facultyReqDto){
		return facultyServie.updateFaculty(id, facultyReqDto);
		
	}
	

}
