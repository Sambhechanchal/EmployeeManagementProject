package com.nt.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nt.entity.Employee;
import com.nt.service.EmployeeService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService empService;
	
	@PostMapping("/empsave")
	public String postMethodName(@RequestBody Employee emp) {
	String msg = empService.saveEmployee(emp);
		if(msg == null || msg.isEmpty())
			return "Failed.....!";
		return "Employee saved successfully.........!";
	}
	@PutMapping("/updateEmployee")
	public String updateEmp(@RequestBody Employee emp) {
		
		String empObj = empService.updateEmployeeData(emp);
		return empObj;
	}
	
	@GetMapping("/getEmployee/{id}")
	public Employee getEmployeeById(@PathVariable Long id) {
		
		return empService.getEmpById(id);
	}
	
	@GetMapping("/getAllEmployees")
	public Iterable<Employee> getEmployeeS() {
		
		return empService.getAllEmp();
	}
	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmployeeById(@PathVariable Long id) {
		
		return empService.deleteEmpById(id);
	}

	@GetMapping("/deleteAllEmp")
	public String deleteAllEmployees() {
		
		return empService.deleteAllEmp();
	}

}
