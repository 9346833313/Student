package com.example.student.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.student.Dto.FacultyReqDto;
import com.example.student.ResDto.FacultyResDto;
import com.example.student.ResDto.ResponseDto;
import com.example.student.ResDto.ResponseMessage;
import com.example.student.entity.Faculty;
import com.example.student.repository.FacultyRepository;
import com.example.student.service.FacultyService;

@Service
public class FacultyServiceImpl implements FacultyService {

	@Autowired
	private FacultyRepository facultyRepository;

	/**
	 * This method is used to create faculty details and save in Faculty table.
	 * 
	 * @param facultyReqDto contains faculty details
	 * @return response object
	 */
	@Override
	public ResponseEntity<?> createFaculty(FacultyReqDto facultyReqDto) {
		ResponseDto response = new ResponseDto();
		try {
			Faculty faculty = new Faculty();

			faculty.setId(facultyReqDto.getId());
			faculty.setFname(facultyReqDto.getFname());
			faculty.setFsubject(facultyReqDto.getFsubject());
			faculty.setDescription(facultyReqDto.getDescription());
			facultyRepository.save(faculty);

			response.setStatusCode(200);
			response.setIsError(false);
			response.setResult(new ResponseMessage("Faculty Saved Successfully"));
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			response.setStatusCode(500);
			response.setIsError(true);
			response.setResult(new ResponseMessage(
					"Technical Error Occured, Unable to save Faculty. Error Message: " + e.getMessage()));
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	/**
	 * This method is used to get faculty from the database based on Id.
	 * 
	 * @param id
	 * 
	 */
	@Override
	public ResponseEntity<?> findFacultyById(Long id) {
		ResponseDto response = new ResponseDto();

		try {
			Optional<Faculty> facultyById = facultyRepository.findById(id);
			if (facultyById.isPresent()) {

				Faculty faculty = facultyById.get();

				FacultyResDto facultyResDto = new FacultyResDto();

				facultyResDto.setId(faculty.getId());
				facultyResDto.setFname(faculty.getFname());
				facultyResDto.setFsubject(faculty.getFsubject());
				facultyResDto.setDescription(faculty.getDescription());

				response.setStatusCode(200);
				response.setIsError(false);
				response.setResult(facultyResDto);
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

	/**
	 * This method is used to getAll faculty from the database.
	 * 
	 */
	@Override
	public ResponseEntity<?> getAllFaculty() {
		ResponseDto response = new ResponseDto();
		try {
			List<Faculty> findAll = facultyRepository.findAll();
			response.setStatusCode(200);
			response.setIsError(false);
			response.setResult(findAll);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			response.setStatusCode(500);
			response.setIsError(true);
			response.setResult(new ResponseMessage(
					"Technical Error Occured, Unable to getAll Faculty. Error Message: " + e.getMessage()));
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * This method is used to Update faculty name, subject and description
	 * 
	 * @param facultyReqDto contains faculty details
	 * @return response object
	 */
	@Override
	public ResponseEntity<?> updateFaculty(FacultyReqDto facultyReqDto) {
		ResponseDto response = new ResponseDto();
		try {

			Optional<Faculty> findById = facultyRepository.findById(facultyReqDto.getId());
			if (!findById.isPresent()) {

				response.setStatusCode(400);
				response.setIsError(true);
				response.setResult(new ResponseMessage("Faculty not found"));
				return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
			} else {

				Faculty faculty = findById.get();
				faculty.setFname(facultyReqDto.getFname());
				faculty.setFsubject(facultyReqDto.getFsubject());
				faculty.setDescription(facultyReqDto.getDescription());
				facultyRepository.save(faculty);

				response.setStatusCode(200);
				response.setIsError(false);
				response.setResult(new ResponseMessage("Faculty Updated Successfully"));
				return new ResponseEntity<>(response, HttpStatus.OK);
			}
		} catch (Exception e) {
			e.printStackTrace();
			response.setStatusCode(500);
			response.setIsError(true);
			response.setResult(new ResponseMessage(
					"Technical Error Occured, Unable to update Faculty. Error Message: " + e.getMessage()));
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * This method is used to delete the faculty from database based on id
	 * 
	 */
	@Override
	public ResponseEntity<?> deleteFacultyId(long facultyId) {
		ResponseDto response = new ResponseDto();
		try {
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
		} catch (Exception e) {
			e.printStackTrace();
			response.setStatusCode(500);
			response.setIsError(true);
			response.setResult(new ResponseMessage(
					"Technical Error Occured, Unable to update Faculty. Error Message: " + e.getMessage()));
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}