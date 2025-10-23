package com.nt.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.nt.entity.Employee;
import com.nt.repository.EmployeeRepo;
import com.nt.service.EmployeeService;

@Service
@Profile({"dev", "qa"})
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepo empRepo;

	@Override
	public String saveEmployee(Employee emp) {
		empRepo.save(emp);
		return "Successfully saved";
	}

	@Override
	public String updateEmployeeData(Employee emp) {
		empRepo.save(emp);
		return "Employee updated Successfully......!";
	}

	@Override
	public Employee getEmpById(Long id) {
		Optional<Employee> opt = empRepo.findById(id);
		if(opt.isPresent()) {
			return  opt.get();
		}else {
			throw new RuntimeException("Invalid Id");
		}
	}
	
	@Override
	public String deleteEmpById(Long id) {
		Optional<Employee> opt = empRepo.findById(id);
		if(opt.isPresent()) {
			empRepo.delete(opt.get());
			return  "Employee Delete successfully....!";
		}else {
			throw new RuntimeException("Invalid Id");
		}
	}

	@Override
	public Iterable<Employee> getAllEmp() {
		
		return empRepo.findAll();
	}
	
	@Override
	public String deleteAllEmp() {
			empRepo.deleteAll();
			return  "Employee Delete successfully....!";
		
	}
	

}
