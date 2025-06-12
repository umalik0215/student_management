package com.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.helper.ResponsesEntity;
import com.test.model.Student;
import com.test.service.StudentService;

@RestController
@RequestMapping("/api/students")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@PostMapping("/")
	public ResponsesEntity createStudent(@RequestBody Student student) {
		return studentService.createStudent(student);
	}

	@GetMapping("/")
	public ResponsesEntity getStudents() {
		return studentService.getStudents();
	}

	@GetMapping("/get-by-name/{studentName}")
	public ResponsesEntity getStudent(@PathVariable String studentName) {
		return studentService.getStudentByName(studentName);
	}

	@PutMapping("/")
	public ResponsesEntity updateStudent(@RequestBody Student student) {
		return studentService.updateStudent(student);
	}

	@DeleteMapping("/{studentName}")
	public ResponsesEntity deleteStudent(@PathVariable String studentName) {
		return studentService.deleteStudent(studentName);
	}

}
