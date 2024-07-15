package com.example.student.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.student.entity.Faculty;
import com.example.student.repository.FacultyRepository;
import com.example.student.service.FacultyServie;

@Service
public class FacultyServiceImpl implements FacultyServie {
	@Autowired
	private FacultyRepository facultyRepository;

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

}
