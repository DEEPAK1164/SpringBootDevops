package com.example.Module2.controller;
import java.util.List;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.Module2.dto.EmployeeDTO;
import com.example.Module2.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    // Constructor Injection
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // ================== GET ==================

    // GET /employee/1
    @GetMapping("/{employeeId}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable Long employeeId) {
        EmployeeDTO employeeDTO = employeeService.getEmployeeById(employeeId);
        if (employeeDTO == null) {
            return ResponseEntity.notFound().build(); // 404
        }
        return ResponseEntity.ok(employeeDTO); // 200
    }


    @GetMapping("/employees")
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees() {

        List<EmployeeDTO> employees = employeeService.getAllEmployees();

        if (employees.isEmpty()) {
            return ResponseEntity.noContent().build(); // 204 NO CONTENT
        }

        return ResponseEntity.ok(employees); // 200 OK
    }


    // ================== POST ==================

    @PostMapping
    public ResponseEntity<EmployeeDTO> createEmployee(@RequestBody @Valid EmployeeDTO employee) {

        EmployeeDTO createdEmployee = employeeService.createEmployee(employee);

        return ResponseEntity
                .status(HttpStatus.CREATED) // 201
                .body(createdEmployee);
    }


    // ================== PUT ==================
    @PutMapping("/{employeeId}")
    public ResponseEntity<EmployeeDTO> updateEmployeeById(
            @PathVariable Long employeeId,
            @RequestBody EmployeeDTO updatedEmployee) {

        EmployeeDTO employeeDTO =
                employeeService.updateEmployeeById(employeeId, updatedEmployee);

        return ResponseEntity.ok(employeeDTO); // 200 OK
    }


    

    // ================== PATCH ==================
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

    // DELETE /employee/1
    @DeleteMapping("/{employeeId}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable Long employeeId) {

        employeeService.deleteEmployeeById(employeeId);

        return ResponseEntity
                .status(HttpStatus.OK)   // 200 OK
                .body("Employee with ID " + employeeId + " deleted successfully");
    }

}
