package com.example.Module4.client.Impl;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.example.Module4.advice.ApiResponse;
import com.example.Module4.client.EmployeeClient;
import com.example.Module4.dto.EmployeeDTO;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class EmployeeClientImpl implements EmployeeClient {

    private final RestClient restClient;

    @Override
    public ApiResponse<List<EmployeeDTO>> getAllEmployees() {
        try {
        	ApiResponse<List<EmployeeDTO>> response = restClient
        	        .get()
        	        .uri("/employees")
        	        .retrieve()
        	        .body(new ParameterizedTypeReference<ApiResponse<List<EmployeeDTO>>>() {});

        	return response;

        } 
        catch (Exception e) {
            throw new RuntimeException("Failed to fetch employees from Employee Service", e);
        }
    }

    @Override
    public EmployeeDTO getEmployeeById(Long employeeId) {
        try {
            ApiResponse<EmployeeDTO> response = restClient
                    .get()
                    .uri("/employees/{id}", employeeId)
                    .retrieve()
                    .body(new ParameterizedTypeReference<ApiResponse<EmployeeDTO>>() {});

            return response.getData();

        } catch (Exception e) {
            throw new RuntimeException(
                    "Failed to fetch employee with id " + employeeId,
                    e
            );
        }
    }
    
    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
        try {
            ApiResponse<EmployeeDTO> response = restClient
                    .post()
                    .uri("/employees")
                    .body(employeeDTO)
                    .retrieve()
                    .onStatus(
                            status -> status.is4xxClientError(),
                            (request, responseError) -> {
                                throw new RuntimeException(
                                        "Invalid employee data or client error while creating employee"
                                );
                            }
                    )
                    .onStatus(
                            status -> status.is5xxServerError(),
                            (request, responseError) -> {
                                throw new RuntimeException(
                                        "Employee service failed while creating employee"
                                );
                            }
                    )
                    .body(new ParameterizedTypeReference<ApiResponse<EmployeeDTO>>() {});

            return response.getData();

        } catch (Exception e) {
            throw new RuntimeException(
                    "Failed to create employee",
                    e
            );
        }
    }



    
    
    
}