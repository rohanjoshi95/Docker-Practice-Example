package com.example.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.exception.StudentException;
import com.example.model.Student;
import com.example.service.StudentServiceImpl;

@RestController
public class StudentController {

	public static final Logger LOGGER = LoggerFactory.getLogger(StudentController.class);

	@Autowired
	private StudentServiceImpl studentServiceImpl;

	@PostMapping("/createStudent")
	public ResponseEntity<Student> createStudent(@RequestBody Student student) throws StudentException {
		Student student1 = null;
		try {
			student1 = studentServiceImpl.createStudent(student);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		if (student1 == null) {
			throw new StudentException("No student created");
		} else {
			return new ResponseEntity<Student>(student1, HttpStatus.OK);
		}

	}

	@GetMapping("/getStudent/{id}")
	public ResponseEntity<Student> getStudent(@PathVariable Integer id) throws StudentException {
		Student student = null;
		try {
			student = studentServiceImpl.getStudent(id);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		if (student == null) {
			throw new StudentException("No student present with Id =" + id);
		} else {
			return new ResponseEntity<Student>(student, HttpStatus.OK);
		}

	}

	@GetMapping("/getAllStudents")
	public ResponseEntity<List<Student>> getAllStudents() throws StudentException {
		List<Student> students = null;
		try {
			students = studentServiceImpl.getAllStudents();
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		if (students == null || students.isEmpty()) {
			throw new StudentException("Student list is empty");
		} else {
			return new ResponseEntity<List<Student>>(students,HttpStatus.OK);
		}

	}

	@DeleteMapping("/deleteStudent/{id}")
	public boolean deleteStudent(@PathVariable Integer id) throws StudentException {
		boolean result = false;
		try {
			result = studentServiceImpl.deleteStudent(id);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		if (result) {
			return true;
		} else {
			throw new StudentException("Student not deleted");
		}

	}

}
