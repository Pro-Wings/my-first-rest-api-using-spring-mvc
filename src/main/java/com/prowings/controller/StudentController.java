package com.prowings.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.prowings.entity.Student;
import com.prowings.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	StudentService studentService;

	@PostMapping("/students")
	public String createStudent(@RequestBody Student std) {
		System.out.println("request received to create student  : " + std);

		if (studentService.saveStudent(std))
			return "Student saved successfully!!!";
		else
			return "Student not saved!!!";

	}

	@GetMapping("/students/{id}")
	public Student getStudent(@PathVariable("id") int id) {
		System.out.println("request received to get student of id : " + id);

		Student retrivedStudent = studentService.getStudent(id);

		return retrivedStudent;

	}
}
