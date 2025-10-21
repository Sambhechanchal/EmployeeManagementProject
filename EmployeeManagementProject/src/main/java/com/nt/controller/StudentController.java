package com.nt.controller;

import java.net.HttpURLConnection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nt.entity.Student;
import com.nt.model.ResponseMessage;
import com.nt.service.StudentService;
import com.nt.utility.Constants;


@RestController
public class StudentController {
	
	@Autowired
	private StudentService stdService;
	
	@PostMapping("/saveStudent")
	public ResponseEntity<ResponseMessage> saveStudent(@RequestBody Student std){
		Student student = stdService.createStudent(std);
		return ResponseEntity.ok(new ResponseMessage(HttpURLConnection.HTTP_CREATED, Constants.SUCCESS, "student data saved successfully...!", student));
	}
	
	@GetMapping("/getbyemail")
	public ResponseEntity<ResponseMessage> getByEmail(@RequestParam String email) {
		 Student byStudentEmail = stdService.findByStudentEmail(email);
		 
		if(byStudentEmail != null) {
		return ResponseEntity.ok(new ResponseMessage(HttpURLConnection.HTTP_CREATED, Constants.SUCCESS, "student data fetched successfully...!", byStudentEmail));
		}else {
			return ResponseEntity.ok(new ResponseMessage(HttpURLConnection.HTTP_BAD_REQUEST, Constants.FAILED, "student data not fetched", byStudentEmail));
		}
		
	}
	
	@PutMapping("/updatemarks")
	public ResponseEntity<ResponseMessage> updateMarks(@RequestParam String email, @RequestParam int marks) {
		 Student byStudentEmail = stdService.updateStudentMarksByEmail(marks, email);
		 
		if(byStudentEmail != null) {
		return ResponseEntity.ok(new ResponseMessage(HttpURLConnection.HTTP_CREATED, Constants.SUCCESS, "student data fetched successfully...!", byStudentEmail));
		}else {
			return ResponseEntity.ok(new ResponseMessage(HttpURLConnection.HTTP_BAD_REQUEST, Constants.FAILED, "student data not fetched", byStudentEmail));
		}
		
	}
		
	

}
