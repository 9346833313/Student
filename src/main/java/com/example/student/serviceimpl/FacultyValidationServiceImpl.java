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

}
