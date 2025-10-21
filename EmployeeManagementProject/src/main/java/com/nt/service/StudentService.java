package com.nt.service;

import com.nt.entity.Student;

public interface StudentService {

 public Student findByStudentEmail(String email);

 public Student createStudent(Student std);

 public Student updateStudentMarksByEmail(int marks,String email);

}
