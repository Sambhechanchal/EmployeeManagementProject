package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nt.entity.Student;

import jakarta.transaction.Transactional;

//@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {

	@Query(value="select * from std where email = :email", nativeQuery = true)
	public Student findByEmail(@Param("email") String email);
	
	@Transactional
	@Modifying
@Query(value="update std set marks =:marks where email =:email", nativeQuery=true)
public void updateMarksByEmail(@Param ("marks") int marks,@Param ("email") String email);

	}



