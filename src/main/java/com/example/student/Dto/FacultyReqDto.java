package com.example.student.Dto;

public class FacultyReqDto {
	
	private long id;
	private String Fname;
	private String Fsubject;
	private String description;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFname() {
		return Fname;
	}
	public void setFname(String fname) {
		Fname = fname;
	}
	public String getFsubject() {
		return Fsubject;
	}
	public void setFsubject(String fsubject) {
		Fsubject = fsubject;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	
	
}
