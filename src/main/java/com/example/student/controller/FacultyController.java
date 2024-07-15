package com.example.student.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.student.Dto.FacultyReqDto;

import com.example.student.service.FacultyService;

@RestController
@RequestMapping("/api")
public class FacultyController {
	@Autowired
	private FacultyService facultyService;

	@PostMapping("facultys")
	ResponseEntity<?> createFaculty(@RequestBody FacultyReqDto facultyReqDto) {
		return facultyService.createFaculty(facultyReqDto);

	}

	/**
	 * Endpoint to find a faculty member by their ID. Map GET requests to
	 * /facultys/{id} Call the service method to find the faculty member by ID
	 */
	@GetMapping("/facultys/{id}")
	public ResponseEntity<?> findFacultyById(@PathVariable Long id) {
		return facultyService.findFacultyById(id);
	}

	@GetMapping("/facultys/all")
	public ResponseEntity<?> getAllFaculty() {
		return facultyService.getAllFaculty();
	}

	@PostMapping("facultys/update")
	ResponseEntity<?> updateFaculty(@RequestBody FacultyReqDto facultyReqDto) {
		return facultyService.updateFaculty(facultyReqDto);

	}

	/**
	 * Endpoint to delete a faculty member by their ID. Map DELETE requests to
	 * /facultys/{id} Call the service method to delete the faculty member by ID
	 */
	@DeleteMapping("/facultys/{id}")
	public ResponseEntity<?> deleteFaculty(@PathVariable long id) {
		return facultyService.deleteFacultyId(id);
	}

}
