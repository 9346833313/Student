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

	/**
	 * This method is used to call the CreateFaculty method which is present in
	 * facultyService interface.
	 * 
	 * @param facultyReqDto contains faculty details
	 * @return response object
	 */
	@PostMapping("facultys/create")
	ResponseEntity<?> createFaculty(@RequestBody FacultyReqDto facultyReqDto) {
		return facultyService.createFaculty(facultyReqDto);

	}

	/**
	 * This method is used to call the Get faculty by id method which is present in
	 * the faculty service interface.
	 * 
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/facultys/{id}")
	public ResponseEntity<?> getFacultyById(@PathVariable Long id) {
		return facultyService.getFacultyById(id);
	}

	/**
	 * This method is used to call the getAll method which is present in
	 * facultyService interface.
	 * 
	 * @return
	 */
	@GetMapping("/facultys/all")
	public ResponseEntity<?> getAllFaculty() {
		return facultyService.getAllFaculty();
	}

	/**
	 * This method is used to call the update faculty method which is present in
	 * facultyService Interface
	 * 
	 * @param facultyReqDto contains faculty details
	 * @return response object
	 */
	@PostMapping("facultys/update")
	ResponseEntity<?> updateFaculty(@RequestBody FacultyReqDto facultyReqDto) {
		return facultyService.updateFaculty(facultyReqDto);
	}

	/**
	 * This method is used to call the delete method which is present in
	 * facultyService interface.
	 * 
	 * @param id
	 */
	@DeleteMapping("/facultys/{id}")
	public ResponseEntity<?> deleteFaculty(@PathVariable long id) {
		return facultyService.deleteFacultyId(id);
	}

}
