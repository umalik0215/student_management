package com.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.helper.ResponsesEntity;
import com.test.model.Student;
import com.test.repository.StudentDao;
import com.test.validation.StudentValidation;

@Service
public class StudentService {

	@Autowired
	private StudentDao studentDao;

	@Autowired
	private StudentValidation studentValidation;

	public ResponsesEntity createStudent(Student student) {
		ResponsesEntity responsesEntity = new ResponsesEntity();
		List<String> dataValidationMessages = studentValidation.isDataValidForUser(student, "create");

		if (dataValidationMessages.size() > 0) {
			responsesEntity.setMessage(dataValidationMessages);
			return responsesEntity;
		}

		Student saveUser = studentDao.save(student);
		responsesEntity.setData(saveUser);

		return responsesEntity;
	}

	public ResponsesEntity getStudents() {
		ResponsesEntity responsesEntity = new ResponsesEntity();
		List<Student> students = studentDao.findAll();
		responsesEntity.setData(students);
		return responsesEntity;
	}

	public ResponsesEntity getStudentByName(String studentName) {
		ResponsesEntity responsesEntity = new ResponsesEntity();
		Student studentData = studentDao.findByName(studentName).orElse(new Student());
		responsesEntity.setData(studentData);
		return responsesEntity;
	}

	public ResponsesEntity updateStudent(Student student) {
		ResponsesEntity responsesEntity = new ResponsesEntity();
		List<String> dataValidationMessages = studentValidation.isDataValidForUser(student, "update");

		if (dataValidationMessages.size() > 0) {
			responsesEntity.setMessage(dataValidationMessages);
			return responsesEntity;
		}

		Student domainEntity = (Student) getStudentByName(student.getName()).getData();
		domainEntity.setAge(student.getAge());
		domainEntity.setPhone(student.getPhone());
		domainEntity.setStudentClass(student.getStudentClass());

		Student updatedStudent = studentDao.saveAndFlush(domainEntity);
		responsesEntity.setData(updatedStudent);
		return responsesEntity;
	}

	public ResponsesEntity deleteStudent(String studentName) {
		ResponsesEntity responsesEntity = new ResponsesEntity();
		
		Student student = new Student();
		student.setName(studentName);
		List<String> dataValidationMessages = studentValidation.isDataValidForUser(student, "delete");

		if (dataValidationMessages.size() > 0) {
			responsesEntity.setMessage(dataValidationMessages);
			return responsesEntity;
		}
		Student domainEntity = (Student) getStudentByName(studentName).getData();
		studentDao.deleteById(domainEntity.getId());
		responsesEntity.setData(domainEntity);
		return responsesEntity;
	}

}
