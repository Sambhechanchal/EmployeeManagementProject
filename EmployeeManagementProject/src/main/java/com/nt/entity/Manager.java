package com.nt.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="manager")
@AllArgsConstructor
@NoArgsConstructor
public class Manager {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="mngName")
	private String mngName;
	
	@Column(name="mngAddrs")
	private String mngAddrs;
	
	@Column(name="salary")
	private double salary;
	
	@Column(name="created")
	private LocalDateTime created;
	
	@Column(name="updated")
	private LocalDateTime updated;
}
