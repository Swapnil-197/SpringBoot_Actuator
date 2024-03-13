package com.sb.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sb.constants.GlobalConstants;
import com.sb.pojo.Student;

@RestController
@RequestMapping(GlobalConstants.STUDENT_CONTROLLER_MAPPING)
public class StudentController {
	
	@GetMapping("/getAllStudents")
	public List<Student> getAllStudents(){
		List<Student> listOfStudents = new ArrayList<>();
		Student student = new Student();
		student.setSid(1);
		student.setName("Swapnil");
		student.setCourse("Java");
		listOfStudents.add(student);
		Student student1 = new Student();
		student1.setSid(2);
		student1.setName("Nayan");
		student1.setCourse("Python");
		listOfStudents.add(student1);
		Student student3 = new Student();
		student3.setSid(3);
		student3.setName("Pavan");
		student3.setCourse("Ruby");
		listOfStudents.add(student3);
		return listOfStudents;
	}
	
	@GetMapping("/nameOfStudents")
	public List<String> nameOfStudents(){
		return Arrays.asList("Swapnil","Nayan","Trupti","Shubham");
		
	}
	
	//In this method we are passing input from postman to see on console with the help of
	// PostMappnig and RequestBody annotation
	@PostMapping(path = "/addStudent")
	public Student addStudent(@RequestBody Student student) {
		System.out.println(student);
		//hibernate code to store into database
		return student;
	}
	
	//from UI(from POSTMAN we can send data through URL with the help of @PathVariable annotation)
	@PostMapping(path = "/getStudentById/{studentId}")
	public Integer getStudentById(@PathVariable Integer studentId) {
		System.out.println(studentId);
		//hibernate code to store into database
		return studentId;
	}
	
	@PostMapping(path = "/getStudentByIdRP")
	public Integer getStudentByIdRP(@RequestParam(name="studentId")Integer studentId,
			@RequestParam(name = "studentName",required = false,defaultValue = "NA")String studentName) {
		System.out.println(studentId);
		System.out.println(studentName);
		return studentId;
	}
	
	@PostMapping(path = "/checkVersion")
	public Integer checkVersion(@RequestParam(name="studentId")Integer studentId,
			      @RequestHeader(name = "version" , required = false) String version) {
		System.out.println(studentId);
		if(version !=null) {
		if(version.equals("2")) {
			return 123456;
		}else {
			return studentId;
		}
	  }
		return 11;
	}
}
 