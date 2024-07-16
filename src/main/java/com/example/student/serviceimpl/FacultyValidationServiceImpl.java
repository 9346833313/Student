package com.example.student.serviceimpl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import com.example.student.service.FacultyValidationService;

@Service
public class FacultyValidationServiceImpl implements FacultyValidationService {

	@Override
	public boolean isValidFName(String name) {
		if (!isNameBlank(name) && !beginOrEndWithDot(name) && isSufficientLengthFName(name)) {
			String regex = "^([a-zA-Z.']){1,30}$";
			Pattern p = Pattern.compile(regex);
			if (name == null) {
				return false;
			}
			Matcher m = p.matcher(name);
			return m.matches();
		} else {
			return false;
		}
	}

	private boolean isSufficientLengthFName(String name) {
		if (name.trim().length() >= 1 && name.trim().length() <= 30) {
			return true;
		} else {
			return false;
		}
	}

	private boolean beginOrEndWithDot(String name) {
		if (name.trim().startsWith(".") || name.trim().endsWith(".")) {
			return true;
		}
		return false;
	}

	private boolean isNameBlank(String name) {
		return name.trim().isEmpty();
	}

	@Override
	public boolean isValidDescription(String description) {
		if (description == null) {
			return false;
		}
		if (!isNameBlank(description) && isSufficientlengthForDescription(description) && !beginWithDot(description)) {
			String regex = "^[\\w\\s\\-',.]{2,300}$";

			Pattern p = Pattern.compile(regex);

			Matcher m = p.matcher(description);
			return m.matches();

		} else {
			return false;
		}
	}

	private boolean beginWithDot(String description) {
		return description.trim().startsWith(".");
	}

	private boolean isSufficientlengthForDescription(String description) {
		return description.trim().length() >= 2 && description.trim().length() <= 300;
	}

	@Override
	public boolean isValidSubject(String subject) {
		if (!isNameBlank(subject) && !beginOrEndWithDot(subject) && isSufficientLengthFName(subject)) {
			String regex = "^([a-zA-Z.']){1,30}$";
			Pattern p = Pattern.compile(regex);
			if (subject == null) {
				return false;
			}
			Matcher m = p.matcher(subject);
			return m.matches();
		} else {
			return false;
		}
	}

}
