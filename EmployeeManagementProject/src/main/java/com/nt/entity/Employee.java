package com.nt.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="Emp_Tab")
@Data
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="empName")
	private String empName;
	
	@Column(name="empAddrs")
	private String empAddrs;
	
	@Column(name="salary")
	private double salary;
	
	@CreationTimestamp
	@Column(name="CreationTime")
	private LocalDateTime created;
	
	@UpdateTimestamp
	@Column(name="updationTime")
	private LocalDateTime updated;

}
