package com.example.student.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.student.Dto.StudentDTO;
import com.example.student.ResDto.ResponseDto;
import com.example.student.ResDto.ResponseMessage;
import com.example.student.entity.Student;
import com.example.student.repository.StudentRepo;
import com.example.student.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepo studentRepo;

	@Override

	/*
	 *
	 * Creates a new student.
	 */

	public ResponseEntity<?> createStudent(StudentDTO studentDTO) {
		ResponseDto response = new ResponseDto();
		try {
			Student student = new Student();
			studentDTO.setName(student.getName());
			studentDTO.setRollNo(studentDTO.getRollNo());
			studentRepo.save(student);
			response.setIsError(false);
			response.setStatusCode(200);
			response.setResult(new ResponseMessage("student created ucessfully"));
			return new ResponseEntity<>(response, HttpStatus.OK);

		} catch (Exception e) {

			response.setIsError(true);
			response.setStatusCode(400);
			response.setResult(new ResponseMessage("failed to save the data"));
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
	}

	/*
	 * Retrieves all students
	 */

	@Override
	public ResponseEntity<?> getStudent() {
		ResponseDto response = new ResponseDto();
		try {
			List<Student> findAll = studentRepo.findAll();
			response.setIsError(false);
			response.setStatusCode(200);
			response.setResult(findAll);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			response.setIsError(true);
			response.setStatusCode(500);
			response.setResult(new ResponseMessage("Failed to retrieve the data"));
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// Student details get by id - serviceImpl class
	@Override
	public ResponseEntity<ResponseDto> getById(long id) {
		Optional<Student> findById = studentRepo.findById(id);
		if (findById.isPresent()) {
			Student student = findById.get();
			StudentDTO studentDTO = new StudentDTO();
			studentDTO.setId(student.getId());
			studentDTO.setName(student.getName());
			studentDTO.setRollNo(student.getRollNo());

			ResponseDto responseDto = new ResponseDto();
			responseDto.setStatusCode(HttpStatus.OK.value());
			responseDto.setIsError(false);
			responseDto.setResult(studentDTO);
			return ResponseEntity.ok(responseDto);
		} else {
			ResponseDto responseDto = new ResponseDto();
			responseDto.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseDto.setIsError(true);
			responseDto.setResult(new ResponseMessage("User not found"));
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseDto);
		}
	}

	// Student details update by id - serviceImpl class
	@Override
	public ResponseEntity<ResponseDto> updateUser(StudentDTO studentDto, long id) {
		Optional<Student> findById = studentRepo.findById(id);
		if (findById.isPresent()) {
			Student existingStudent = findById.get();
			existingStudent.setName(studentDto.getName());
			existingStudent.setRollNo(studentDto.getRollNo());

			studentRepo.save(existingStudent);

			ResponseDto responseDto = new ResponseDto();
			responseDto.setStatusCode(HttpStatus.OK.value());
			responseDto.setIsError(false);
			responseDto.setResult(new ResponseMessage("Student updated successfully"));
			return ResponseEntity.ok(responseDto);

		}

		else {

			ResponseDto responseDto = new ResponseDto();
			responseDto.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseDto.setIsError(true);
			responseDto.setResult(new ResponseMessage("Student not found"));
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseDto);
		}
	}

	@Override
	public ResponseEntity<?> delete(long id) {
		Optional<Student> findById = studentRepo.findById(id);
		if (findById.isPresent()) {
			Student std = findById.get();

			return new ResponseEntity<>(std, HttpStatus.OK);

		} else {
			return new ResponseEntity<>("id not found", HttpStatus.BAD_REQUEST);
		}

	}

}
