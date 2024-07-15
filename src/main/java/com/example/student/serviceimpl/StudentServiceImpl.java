package com.example.student.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

	public ResponseEntity<?> createStudent(Student student) {
		return new ResponseEntity<>(studentRepo.save(student), HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<?> getStudent() {
		return new ResponseEntity<>(studentRepo.findAll(), HttpStatus.OK);
	}
	
	// Student details get by id - serviceImpl
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

	// Student details update by id - serviceImpl
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
        } else {
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
