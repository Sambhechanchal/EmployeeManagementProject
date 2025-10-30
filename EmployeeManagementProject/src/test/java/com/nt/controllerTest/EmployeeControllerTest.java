package com.nt.controllerTest;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nt.controller.EmployeeController;
import com.nt.entity.Employee;
import com.nt.service.EmployeeService;

@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {

	
	
	@MockBean
	private EmployeeService empService;
	
	@Mock
	private MockMvc mock;
	
	
	@Test
	public void createEmployeeTest()throws Exception {
		
		// input
		Employee input = new Employee();
		input.setEmpName("Karan");
		input.setEmpAddrs("pune");
		input.setSalary(90000);
		
		//output
		String msg ="Employee Saved successfully....!";
		// service call
		when(empService.saveEmployee(input)).thenReturn(msg);
		
		mock.perform(
				
				post("/empsave")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(msg))
				);
	}
	
}
