package com.example.student.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.student.Dto.FacultyReqDto;
import com.example.student.ResDto.ResponseDto;
import com.example.student.ResDto.ResponseMessage;
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
	public ResponseEntity<?> findFacultyById(Long id) {
		ResponseDto response = new ResponseDto();

		try {
			Optional<Faculty> faculty = facultyRepository.findById(id);
			if (faculty.isPresent()) {

				response.setStatusCode(200);
				response.setIsError(false);
				response.setResult("");
				return new ResponseEntity<>(response, HttpStatus.OK);
			} else {
				response.setStatusCode(400);
				response.setIsError(true);
				response.setResult(new ResponseMessage("User not found with id: " + id));
				return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			response.setStatusCode(500);
			response.setIsError(true);
			response.setResult(new ResponseMessage("An unexpected error occurred. Please try again later."));
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<?> getAllFaculty() {
		// TODO Auto-generated method stub
		return null;
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

	@Override
	public ResponseEntity<ResponseDto> deleteFacultyId(long facultyId) {
		ResponseDto response = new ResponseDto();
		Optional<Faculty> faculty = facultyRepository.findById(facultyId);
		if (faculty.isPresent()) {
			facultyRepository.deleteById(facultyId);
			response.setStatusCode(200);
			response.setIsError(false);
			response.setResult(new ResponseMessage("Faculty Id deleted successfully"));
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			response.setStatusCode(400);
			response.setIsError(true);
			response.setResult(new ResponseMessage("Faculty not found with id: " + facultyId));
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}
	}

}