package com.example.student.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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
