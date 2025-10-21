package com.nt.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Student;
import com.nt.repository.StudentRepo;
import com.nt.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepo stdRepo;

	@Override
	public Student findByStudentEmail(String email) {
		if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("Email must not be null or empty");
        }
		System.out.println("email"+email);
		 Student byEmail = stdRepo.findByEmail(email);
		 System.out.println("student "+ byEmail.toString());
		return byEmail;
	}

	@Override
	public Student createStudent(Student std) {
		Student save = stdRepo.save(std);
		return save;
	}

	@Override
	public Student updateStudentMarksByEmail( int marks,String email) {
		stdRepo.updateMarksByEmail(marks,email);
		return findByStudentEmail(email);
	}
	
	

}
