package com.example.student.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.student.Dto.FacultyReqDto;
import com.example.student.entity.Faculty;
import com.example.student.repository.FacultyRepository;
import com.example.student.service.FacultyService;

@Service
public class FacultyServiceImpl implements FacultyService {

	@Autowired
	private FacultyRepository facultyRepository;
	
	@Override
	public ResponseEntity<?> createFaculty(FacultyReqDto facultyReqDto) {

		Faculty faculty = new Faculty();

		faculty.setId(facultyReqDto.getId());
		faculty.setFname(facultyReqDto.getFname());
		faculty.setFsubject(facultyReqDto.getFsubject());
		faculty.setDescription(facultyReqDto.getDescription());
		facultyRepository.save(faculty);

		return new ResponseEntity<>("Faculty Saved Successfully", HttpStatus.OK);
	}

	@Override
	public List<Faculty> getAllFaculty() {
		return facultyRepository.findAll();
	}

	@Override
	public Faculty getFacultyById(long id) {
		Optional<Faculty> optionalFaculty = facultyRepository.findById(id);
		return optionalFaculty.get();
	}

	@Override
	public void deleteFacultyById(long id) {
		// TODO Auto-generated method stub
		facultyRepository.deleteById(id);
	}

	

	@Override
	public ResponseEntity<?> updateFaculty(FacultyReqDto facultyReqDto) {

		Optional<Faculty> findById = facultyRepository.findById(facultyReqDto.getId());
		if (!findById.isPresent()) {
			return new ResponseEntity<>("Faculty not found", HttpStatus.NOT_FOUND);
		}

		Faculty faculty = findById.get();
		faculty.setFname(facultyReqDto.getFname());
		faculty.setFsubject(facultyReqDto.getFsubject());
		faculty.setDescription(facultyReqDto.getDescription());
		facultyRepository.save(faculty);

		return new ResponseEntity<>("Faculty Updated Successfully", HttpStatus.OK);
	}
}