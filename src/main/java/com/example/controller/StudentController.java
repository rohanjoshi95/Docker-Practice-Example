package com.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.exception.StudentException;
import com.example.logging.LoggingAspect;
import com.example.model.Student;
import com.example.service.StudentServiceImpl;

@RestController
public class StudentController {

	public static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

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

}
