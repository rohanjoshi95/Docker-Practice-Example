package com.example.service;

import java.util.List;

import com.example.exception.StudentException;
import com.example.model.Student;

public interface StudentService {

	Student createStudent(Student student);

	Student getStudent(Integer id) throws StudentException;

	List<Student> getAllStudents() throws StudentException;

	boolean deleteStudent(Integer id);
}
