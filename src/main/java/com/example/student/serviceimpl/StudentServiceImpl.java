package com.example.student.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

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

	/*
	 * 
	 */
	public ResponseEntity<?> getById(long id) {
		Optional<Student> findById = studentRepo.findById(id);
		if (findById.isPresent()) {
			Student user = findById.get();
			return new ResponseEntity<>(user, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public ResponseEntity<?> updateUser(Student student, long id) {
		Optional<Student> findById = studentRepo.findById(id);
		if (findById.isPresent()) {
			Student existingStudent = findById.get();

			existingStudent.setName(student.getName());
			existingStudent.setRollNo(student.getRollNo());

			studentRepo.save(existingStudent);
			return new ResponseEntity<>("Student updated successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Student not found", HttpStatus.NOT_FOUND);
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
