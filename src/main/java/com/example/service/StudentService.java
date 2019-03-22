package com.example.service;

import com.example.exception.StudentException;
import com.example.model.Student;

public interface StudentService {

	Student createStudent(Student student);
	Student getStudent(Integer id) throws StudentException;
	
}
