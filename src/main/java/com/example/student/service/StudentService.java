package com.example.student.service;

import org.springframework.http.ResponseEntity;

import com.example.student.Dto.StudentDTO;
<<<<<<< HEAD
=======
import com.example.student.ResDto.ResponseDto;
>>>>>>> 9b6799e5bf524ea2377e13c0f6e771bf5e08713a
import com.example.student.entity.Student;

public interface StudentService {

<<<<<<< HEAD

	public ResponseEntity<?> createStudent(StudentDTO studentDTO);
=======
	public ResponseEntity<?> createStudent(Student student);
>>>>>>> 9b6799e5bf524ea2377e13c0f6e771bf5e08713a

	public ResponseEntity<?> getStudent();
	// Student details get by id - service interface
	public ResponseEntity<ResponseDto> getById(long id);
	// Student details update by id - service interface
	public ResponseEntity<ResponseDto> updateUser(StudentDTO studentDto, long id);

	public ResponseEntity<?> delete(long id);

}
