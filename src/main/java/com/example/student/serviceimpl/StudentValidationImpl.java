package com.example.student.serviceimpl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.example.student.service.StudentValidation;

public class StudentValidationImpl implements StudentValidation {

	@Override
	public Boolean isValidname(String name) {
		String regex = "^[A-Za-z \\s .]{3,20}$";
		Pattern compile = Pattern.compile(regex);
		String trim = name.trim();
		if (trim.length() >= 3 && trim.length() <= 20) {
			Matcher matcher = compile.matcher(name);
			return matcher.matches();
		}

		return false;
	}

	@Override
	public Boolean isValidRollNo(long rollNo) {
	    String regex = "^[0-9]{1,4}$";  
	    Pattern pattern = Pattern.compile(regex);
	    Matcher matcher = pattern.matcher(String.valueOf(rollNo));
	    return matcher.matches();
	}


}
