package com.example.Module4;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.Module4.advice.ApiResponse;
import com.example.Module4.client.EmployeeClient;
import com.example.Module4.dto.EmployeeDTO;

@SpringBootTest
class Module4ApplicationTests {
   
	@Autowired
	private EmployeeClient employeeClient;

	@Test
	void contextLoads() {
	}
	
	@Test
	void getAllEmployees() {
	    ApiResponse<List<EmployeeDTO>> response =
	            employeeClient.getAllEmployees();

	    List<EmployeeDTO> employeeDTOList = response.getData();

	    System.out.println(employeeDTOList);
	}
	
	@Test
	void getAllEmployeeById() {
	    EmployeeDTO employeeDTO =
	            employeeClient.getEmployeeById(2L);
	    System.out.println(employeeDTO);
	}
	
	@Test
	void createEmployee() {

	    EmployeeDTO request = new EmployeeDTO(
	            null,                               // id must be null for creation
	            "Aaksh Verma",
	            "akash.verma@example.com",
	            33,
	            LocalDate.of(2024, 6, 15),
	            true
	    );

	    EmployeeDTO createdEmployee =
	            employeeClient.createEmployee(request);

	    System.out.println(createdEmployee);

	 
	}



}
