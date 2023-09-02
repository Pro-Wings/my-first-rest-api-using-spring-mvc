package com.prowings.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.prowings.entity.Student;
import com.prowings.entity.Subject;
import com.prowings.service.StudentService;
import com.prowings.util.StudentNameComparator;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;


@Controller
public class StudentController {

	@Autowired
	StudentService studentService;

	@PostMapping("/students")
	public ResponseEntity<Student> createStudent(HttpEntity<String> httpEntity) throws JsonMappingException, JsonProcessingException {
		
		String requestBody = httpEntity.getBody();
		System.out.println("Incoming Request is : "+requestBody);
		System.out.println(httpEntity.getHeaders());

		ObjectMapper objectMapper = new ObjectMapper();
		
		Student std = objectMapper.readValue(requestBody, Student.class);
		
		System.out.println("request received to create student  : " + std);

		if (studentService.saveStudent(std))
			return new ResponseEntity<Student>(std, HttpStatus.CREATED);
		else
			return null;

	}

	@PutMapping("/students")
	public Student updateStudent(@RequestBody Student std) {
		System.out.println("request received to update student  : " + std);
		
		return studentService.updateStudent(std);
		
	}

	@GetMapping("/students/{id}")
	public Student getStudent(@PathVariable("id") int id) {
		System.out.println("request received to get student of id : " + id);

		Student retrivedStudent = studentService.getStudent(id);
				
//		Link selfLink = linkTo(methodOn(StudentController.class).getStudent(id)).withSelfRel();
//		return retrivedStudent.add(selfLink);

		return retrivedStudent;
	}

	@GetMapping("/students/{id}/subjects")
	public List<Subject> getSubjectsOfSpecifiedStudent(@PathVariable("id") int id) {
		System.out.println("request received to get subjects of specified student id : " + id);
		
		return studentService.getListOfSubjects(id);
		
	}

	@GetMapping("/students")
	public List<Student> getAllStudents( @RequestParam(required = false) Integer firstResult,
		    @RequestParam(required = false) Integer maxResult) {
		System.out.println("request received to get all students");
		
		if((firstResult != null)&&(maxResult != null))
			return studentService.getStudents(firstResult, maxResult);
		else
			return studentService.getStudents();
	}

	@GetMapping("/students/sortByName")
	public List<Student> getAllStudentsSortedByName() {
		System.out.println("request received to get all sorted students by name :");
		
		List<Student> stdList = studentService.getStudents();
		
		Collections.sort(stdList, new StudentNameComparator());
		
		return stdList;
		
	}
	
	

	@GetMapping("/subjects")
	public List<Subject> getAllSubjects() {
		System.out.println("request received to get all subjects");
		
		return studentService.getAllSubjects();
		
	}

	@DeleteMapping("/students/{id}")
	public String deleteStudentById(@PathVariable("id") int id) {
		System.out.println("request received to delete student with id : "+id);
		
		if(studentService.deleteStudent(id))
			return "Student deleted successfully!!";
		else
			return "error while deleteing specified student!!!";
	}
}
