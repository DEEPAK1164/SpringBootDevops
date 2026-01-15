package com.example.Module4.client;

import java.util.List;

import com.example.Module4.advice.ApiResponse;
import com.example.Module4.dto.EmployeeDTO;
public interface EmployeeClient {
    ApiResponse<List<EmployeeDTO>> getAllEmployees();

   EmployeeDTO getEmployeeById(Long employeeId);
   EmployeeDTO createEmployee(EmployeeDTO employeeDTO);

}
