package com.test.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.test.model.Student;
import com.test.repository.StudentDao;

@Configuration
public class StudentValidation {

	@Autowired
	private StudentDao studentDao;

	public List<String> isDataValidForUser(Student student, String requestType) {
		List<String> errorMessages = new ArrayList<>();

		List<String> requiredValidationMessage = requiredFieldsValidation(student,requestType);
		if (requiredValidationMessage.size() > 0) {
			errorMessages.addAll(requiredValidationMessage);
			return errorMessages;
		}
		Boolean isUserExist = isUserExist(student);
		if (requestType.equalsIgnoreCase("create") && BooleanUtils.isTrue(isUserExist)) {
			errorMessages.add("provided student data is exists");
			return errorMessages;
		}

		if ((requestType.equalsIgnoreCase("update") || requestType.equalsIgnoreCase("delete")) && BooleanUtils.isFalse(isUserExist)) {
			errorMessages.add("student data is not exists");
			return errorMessages;
		}

		return errorMessages;
	}

	private Boolean isUserExist(Student student) {
		Student studentData = studentDao.findByName(student.getName()).orElse(new Student());

		if (Objects.isNull(studentData) || StringUtils.isEmpty(studentData.getName())) {
			return Boolean.FALSE;
		}
		return Boolean.TRUE;
	}

	private List<String> requiredFieldsValidation(Student student,String requestType) {
		List<String> errorMessage = new ArrayList<>();

		if ((requestType.equalsIgnoreCase("update") || requestType.equalsIgnoreCase("create") || requestType.equalsIgnoreCase("delete")) && StringUtils.isEmpty(student.getName())) {
			errorMessage.add("Student name is required");
		}
		if ((requestType.equalsIgnoreCase("update") || requestType.equalsIgnoreCase("create") ) && StringUtils.isEmpty(student.getAge())) {
			errorMessage.add("Student age is required");

		}
		if ((requestType.equalsIgnoreCase("update") || requestType.equalsIgnoreCase("create") ) && StringUtils.isEmpty(student.getStudentClass())) {
			errorMessage.add("Student class is required");

		}
		if ((requestType.equalsIgnoreCase("update") || requestType.equalsIgnoreCase("create") ) && student.getPhone() == null) {
			errorMessage.add("Student phone number is required");
		}

		return errorMessage;
	}

}
