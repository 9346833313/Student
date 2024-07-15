package com.example.student.serviceimpl;

<<<<<<< HEAD
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

=======
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
>>>>>>> 9ee139ddce02409ddcee7f6a37a9e7b198bb90b6
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.student.entity.Student;
import com.example.student.repository.StudentRepo;
import com.example.student.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
<<<<<<< HEAD
=======

>>>>>>> 9ee139ddce02409ddcee7f6a37a9e7b198bb90b6
	@Autowired
	private StudentRepo studentRepo;

	@Override
<<<<<<< HEAD
	public ResponseEntity<?> createStudent(Student student) {

		return new ResponseEntity<>(studentRepo.save(student), HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<?> getStudent() {

		return new ResponseEntity<>(studentRepo.findAll(), HttpStatus.OK);
=======
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
>>>>>>> 9ee139ddce02409ddcee7f6a37a9e7b198bb90b6
	}

}
