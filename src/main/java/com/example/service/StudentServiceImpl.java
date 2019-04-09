package com.example.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.exception.StudentException;
import com.example.model.Student;
import com.example.repository.StudentDao;

@Service
public class StudentServiceImpl implements StudentService {

	public static final Logger LOGGER = LoggerFactory.getLogger(StudentServiceImpl.class);

	@Autowired
	private StudentDao studentDao;

	@Override
	@Transactional
	
	public Student createStudent(Student student) {
		return studentDao.save(student);
	}

	@Override
	
	public Student getStudent(Integer id) throws StudentException {
		Optional<Student> list = studentDao.findById(id);
		if (list.isPresent() && id != null) {
			return list.get();
		} else {
			throw new StudentException("Student not found");
		}
	}

	@Override
	public List<Student> getAllStudents() throws StudentException {
		List<Student> list = studentDao.findAll();
		if (!list.isEmpty()) {
			return list;
		} else {
			LOGGER.info("Student list is empty");
			throw new StudentException("Student list is empty");
		}
	}

	@Override
	public boolean deleteStudent(Integer id) {
		if (id != null) {
			studentDao.deleteById(id);
			return true;
		} else {
			LOGGER.info("Student with id " + id + " is not present");
			return false;
		}
	}

}
