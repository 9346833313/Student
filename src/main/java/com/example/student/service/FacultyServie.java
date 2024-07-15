package com.example.student.service;

import java.util.List;

import com.example.student.entity.Faculty;

public interface FacultyServie {

	public List<Faculty> getAllFaculty();

	public Faculty getFacultyById(long id);

	public void deleteFacultyById(long id);

}
