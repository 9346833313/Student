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
import com.example.student.service.StudentValidation;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepo studentRepo;

	@Autowired
	private StudentValidation studentValidation;

	@Override

	/**
	 * Creates a new student.
	 * 
	 * @param studentDTO The DTO containing student information to be created.
	 * 
	 * @return ResponseEntity containing the result of the creation operation and
	 *         HTTP status.
	 */

	public ResponseEntity<?> createStudent(StudentDTO studentDTO) {
		ResponseDto response = new ResponseDto();

		try {
			// checking existing database for name
			Optional<Student> findByRollNo = studentRepo.findByRollNo(studentDTO.getRollNo());
			if (findByRollNo.isPresent()) {
				response.setIsError(true);
				response.setStatusCode(400);
				response.setResult(new ResponseMessage("roll no is already present"));
				return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
			}
			// validations for name

			if (studentDTO.getName() != null) {
				Boolean validname = studentValidation.isValidname(studentDTO.getName());
				if (!validname) {
					response.setIsError(true);
					response.setStatusCode(400);
					response.setResult(new ResponseMessage("provide valid name with limitations"));
					return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
				}
			}
			// validations for roll no
			Long rollNo = studentDTO.getRollNo();
			if (rollNo != null) {
				Boolean validRollNo = studentValidation.isValidRollNo(studentDTO.getRollNo());
				if (!validRollNo) {
					response.setIsError(true);
					response.setStatusCode(400);
					response.setResult(new ResponseMessage("provide valid name with limitations"));
					return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
				}
			}

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

	/**
	 * Retrieves all students.
	 *
	 * @return ResponseEntity containing the list of all students and HTTP status.
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

	/**
	 * Retrieves a student by ID.
	 *
	 * @param id The ID of the student to retrieve.
	 * @return ResponseEntity containing the retrieved student and HTTP status.
	 */
	@Override
	public ResponseEntity<?> getById(long id) {
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

	/**
	 * Updates an existing student.
	 *
	 * @param id         The ID of the student to update.
	 * @param studentDTO The DTO containing updated student information.
	 * @return ResponseEntity containing the result of the update operation and HTTP
	 *         status.
	 */
	@Override
	public ResponseEntity<?> updateUser(StudentDTO studentDto, long id) {

		ResponseDto responseDto = new ResponseDto();

		Optional<Student> findByRollNo = studentRepo.findByRollNo(studentDto.getRollNo());
		if (findByRollNo.isPresent()) {
			responseDto.setIsError(true);
			responseDto.setStatusCode(400);
			responseDto.setResult(new ResponseMessage("roll no is already present"));
			return new ResponseEntity<>(responseDto, HttpStatus.BAD_REQUEST);
		}
		// validations for name

		if (studentDto.getName() != null) {
			Boolean validname = studentValidation.isValidname(studentDto.getName());
			if (!validname) {
				responseDto.setIsError(true);
				responseDto.setStatusCode(400);
				responseDto.setResult(new ResponseMessage("provide valid name with limitations"));
				return new ResponseEntity<>(responseDto, HttpStatus.BAD_REQUEST);
			}
		}
		// validations for roll no
		Long rollNo = studentDto.getRollNo();
		if (rollNo != null) {
			Boolean validRollNo = studentValidation.isValidRollNo(studentDto.getRollNo());
			if (!validRollNo) {
				responseDto.setIsError(true);
				responseDto.setStatusCode(400);
				responseDto.setResult(new ResponseMessage("provide valid name with limitations"));
				return new ResponseEntity<>(responseDto, HttpStatus.BAD_REQUEST);
			}
		}

		Optional<Student> findById = studentRepo.findById(id);
		if (findById.isPresent()) {
			Student existingStudent = findById.get();
			existingStudent.setName(studentDto.getName());
			existingStudent.setRollNo(studentDto.getRollNo());

			studentRepo.save(existingStudent);

			responseDto.setStatusCode(HttpStatus.OK.value());
			responseDto.setIsError(false);
			responseDto.setResult(new ResponseMessage("Student updated successfully"));
			return ResponseEntity.ok(responseDto);

		}

		else {

			responseDto.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseDto.setIsError(true);
			responseDto.setResult(new ResponseMessage("Student not found"));
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseDto);
		}
	}

	/**
	 * Deletes a student by ID.
	 *
	 * @param id The ID of the student to delete.
	 * @return ResponseEntity containing the result of the delete operation and HTTP
	 *         status.
	 */
	@Override
	public ResponseEntity<?> delete(long id) {
		ResponseDto responseDto = new ResponseDto();
		Optional<Student> findById = studentRepo.findById(id);
		if (findById.isPresent()) {
			Student std = findById.get();
			studentRepo.delete(std);
			responseDto.setStatusCode(200);
			responseDto.setIsError(false);
			responseDto.setResult(new ResponseMessage("Student deleted successfully"));
			return new ResponseEntity<>(responseDto,HttpStatus.OK);
		} else {
			responseDto.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseDto.setIsError(true);
			responseDto.setResult(new ResponseMessage("Student not found"));
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseDto);

		}

	}

}
