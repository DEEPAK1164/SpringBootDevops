package com.example.Module4.client.Impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    
    Logger log=LoggerFactory.getLogger(EmployeeClientImpl.class);

    @Override
    public ApiResponse<List<EmployeeDTO>> getAllEmployees() {

        // ENTRY log → TRACE (method flow)
        log.trace("Entering getAllEmployees()");

        try {
            ApiResponse<List<EmployeeDTO>> response = restClient
                    .get()
                    .uri("/employees")
                    .retrieve()
                    .onStatus(
                            status -> status.is4xxClientError(),
                            (request, responseError) -> {
                                log.error("4xx error while calling Employee Service in getAllEmployees()");
                                throw new RuntimeException("Client error while fetching employees");
                            }
                    )
                    .onStatus(
                            status -> status.is5xxServerError(),
                            (request, responseError) -> {
                                log.error("5xx error from Employee Service in getAllEmployees()");
                                throw new RuntimeException("Employee Service failed while fetching employees");
                            }
                    )
                    .body(new ParameterizedTypeReference<ApiResponse<List<EmployeeDTO>>>() {});

            // SUCCESS log → DEBUG
            log.debug("Successfully retrieved employees from Employee Service");

            // DATA log → TRACE (never INFO)
            log.trace("Employee list size: {}", 
                    response.getData() != null ? response.getData().size() : 0);

            return response;

        } catch (Exception e) {
            // FAILURE log → ERROR (always log exception)
            log.error("Exception occurred in getAllEmployees()", e);
            throw new RuntimeException("Failed to fetch employees from Employee Service", e);
        }
    }

    @Override
    public EmployeeDTO getEmployeeById(Long employeeId) {

        // ENTRY → TRACE
        log.trace("Entering getEmployeeById() with employeeId={}", employeeId);

        try {
            ApiResponse<EmployeeDTO> response = restClient
                    .get()
                    .uri("/employees/{id}", employeeId)
                    .retrieve()
                    .onStatus(
                            status -> status.is4xxClientError(),
                            (request, responseError) -> {
                                log.error(
                                    "4xx error while fetching employee. employeeId={}, status={}",
                                    employeeId,
                                    responseError.getStatusCode()
                                );
                                throw new RuntimeException(
                                    "Client error while fetching employee with id " + employeeId
                                );
                            }
                    )
                    .onStatus(
                            status -> status.is5xxServerError(),
                            (request, responseError) -> {
                                log.error(
                                    "5xx error from Employee Service while fetching employee. employeeId={}, status={}",
                                    employeeId,
                                    responseError.getStatusCode()
                                );
                                throw new RuntimeException(
                                    "Employee Service error while fetching employee with id " + employeeId
                                );
                            }
                    )
                    .body(new ParameterizedTypeReference<ApiResponse<EmployeeDTO>>() {});

            // SUCCESS → DEBUG
            log.debug("Successfully fetched employee with id={}", employeeId);

            // DATA → TRACE (safe: single object)
            log.trace("Employee data for id={}: {}", employeeId, response.getData());

            return response.getData();

        } catch (Exception e) {
            // FAILURE → ERROR
            log.error(
                "Exception occurred in getEmployeeById() for employeeId={}",
                employeeId,
                e
            );
            throw new RuntimeException(
                    "Failed to fetch employee with id " + employeeId,
                    e
            );
        }
    }

    
    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {

        // ENTRY → TRACE
        log.trace("Entering createEmployee()");

        try {
            ApiResponse<EmployeeDTO> response = restClient
                    .post()
                    .uri("/employees")
                    .body(employeeDTO)
                    .retrieve()
                    .onStatus(
                            status -> status.is4xxClientError(),
                            (request, responseError) -> {
                                log.error(
                                    "4xx error while creating employee. status={}",
                                    responseError.getStatusCode()
                                );
                                throw new RuntimeException(
                                        "Client error while creating employee"
                                );
                            }
                    )
                    .onStatus(
                            status -> status.is5xxServerError(),
                            (request, responseError) -> {
                                log.error(
                                    "5xx error from Employee Service while creating employee. status={}",
                                    responseError.getStatusCode()
                                );
                                throw new RuntimeException(
                                        "Employee Service error while creating employee"
                                );
                            }
                    )
                    .body(new ParameterizedTypeReference<ApiResponse<EmployeeDTO>>() {});

            // SUCCESS → DEBUG
            log.debug(
                "Employee created successfully with id={}",
                response.getData() != null ? response.getData().getId() : null
            );

            // DATA → TRACE (never INFO)
            log.trace("Created employee response: {}", response.getData());

            return response.getData();

        } catch (Exception e) {
            // FAILURE → ERROR
            log.error("Exception occurred in createEmployee()", e);
            throw new RuntimeException("Failed to create employee", e);
        }
    }



    
    
    
}