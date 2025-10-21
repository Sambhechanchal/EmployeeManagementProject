package com.nt.service;

import com.nt.entity.Employee;

public interface EmployeeService {
	
	public String saveEmployee(Employee emp);

	public String updateEmployeeData(Employee emp);

	public Employee getEmpById(Long id);
	
	public Iterable<Employee> getAllEmp();

	public String deleteEmpById(Long id);

	public String deleteAllEmp();

}
