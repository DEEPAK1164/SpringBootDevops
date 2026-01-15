package com.example.Module2.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.Module2.advices.ApiResponse;
import com.example.Module2.dto.EmployeeDTO;
import com.example.Module2.exceptions.ResourceNotFoundException;
import com.example.Module2.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/employees")   // ✅ BASE PATH MATCHES RESTCLIENT
public class EmployeeController {

    private final EmployeeService employeeService;

    // Constructor Injection
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // ================== GET ==================

    // GET /employees
    @GetMapping
    public ResponseEntity<ApiResponse<List<EmployeeDTO>>> getAllEmployees() {

        List<EmployeeDTO> employees = employeeService.getAllEmployees();

        return ResponseEntity.ok(
            ApiResponse.success(employees)
        );
    }


    // GET /employees/{id}
    @GetMapping("/{employeeId}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable Long employeeId) {

        Optional<EmployeeDTO> employeeDTO =
                employeeService.getEmployeeById(employeeId);

        return employeeDTO
                .map(ResponseEntity::ok)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Employee not found!"));
    }

    // ================== POST ==================

    // POST /employees
    @PostMapping
    public ResponseEntity<EmployeeDTO> createEmployee(
            @RequestBody @Valid EmployeeDTO employee) {

        EmployeeDTO createdEmployee =
                employeeService.createEmployee(employee);

        return ResponseEntity
                .status(HttpStatus.CREATED) // 201
                .body(createdEmployee);
    }

    // ================== PUT ==================

    // PUT /employees/{id}
    @PutMapping("/{employeeId}")
    public ResponseEntity<EmployeeDTO> updateEmployeeById(
            @PathVariable Long employeeId,
            @RequestBody EmployeeDTO updatedEmployee) {

        EmployeeDTO employeeDTO =
                employeeService.updateEmployeeById(employeeId, updatedEmployee);

        return ResponseEntity.ok(employeeDTO); // 200
    }

    // ================== PATCH ==================

    // PATCH /employees/{id}
    @PatchMapping("/{employeeId}")
    public ResponseEntity<EmployeeDTO> updatePartialEmployeeById(
            @PathVariable Long employeeId,
            @RequestBody Map<String, Object> updates) {

        EmployeeDTO employeeDTO =
                employeeService.updatePartialEmployeeById(employeeId, updates);

        if (employeeDTO == null) {
            return ResponseEntity.notFound().build(); // 404
        }

        return ResponseEntity.ok(employeeDTO); // 200
    }

    // ================== DELETE ==================

    // DELETE /employees/{id}
    @DeleteMapping("/{employeeId}")
    public ResponseEntity<String> deleteEmployeeById(
            @PathVariable Long employeeId) {

        employeeService.deleteEmployeeById(employeeId);

        return ResponseEntity.ok(
                "Employee with ID " + employeeId + " deleted successfully");
    }
}
