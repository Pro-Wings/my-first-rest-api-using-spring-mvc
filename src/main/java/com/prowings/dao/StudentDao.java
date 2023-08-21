package com.prowings.dao;

import java.util.List;

import com.prowings.entity.Student;
import com.prowings.entity.Subject;

public interface StudentDao {
	
	public boolean saveStudent(Student std);
	
	public Student getStudent(int id);

	public List<Student> getStudents();
	
	public boolean deleteStudent(int id);

	public Student updateStudent(Student std);


	public List<Subject> getListOfSubjects(int id);

	public List<Subject> getAllSubjects();

	public List<Student> getStudents(Integer firstResult, Integer maxResult);
}
