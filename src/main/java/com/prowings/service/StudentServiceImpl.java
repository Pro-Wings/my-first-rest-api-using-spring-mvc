package com.prowings.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prowings.dao.StudentDao;
import com.prowings.entity.Student;
import com.prowings.entity.Subject;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	StudentDao studentDao;
	
	@Override
	public boolean saveStudent(Student std) {
		return studentDao.saveStudent(std);
	}

	@Override
	public Student getStudent(int id) {
		return studentDao.getStudent(id);
	}

	@Override
	public List<Student> getStudents() {
		return studentDao.getStudents();
	}

	@Override
	public boolean deleteStudent(int id) {
		return studentDao.deleteStudent(id);
	}

	@Override
	public Student updateStudent(Student std) {
		return studentDao.updateStudent(std);
	}

	@Override
	public List<Subject> getListOfSubjects(int id) {
		return studentDao.getListOfSubjects(id);
	}

	@Override
	public List<Subject> getAllSubjects() {
		return studentDao.getAllSubjects();
	}

	@Override
	public List<Student> getStudents(Integer firstResult, Integer maxResult) {
		return studentDao.getStudents(firstResult, maxResult);
	}

}
