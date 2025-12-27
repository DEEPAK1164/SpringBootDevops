package com.example.Module2.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.Module2.dto.EmployeeDTO;
import com.example.Module2.model.Employee;
import com.example.Module2.service.EmployeeService;

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
    public EmployeeDTO getEmployeeById(@PathVariable Long employeeId) {
        return employeeService.getEmployeeById(employeeId);
               
    }

    // GET /employee
    @GetMapping("/employees")
    public List<EmployeeDTO> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    // ================== POST ==================

    // POST /employee
    @PostMapping
    public EmployeeDTO createEmployee(@RequestBody EmployeeDTO employee) {
        return employeeService.createEmployee(employee);
    }

    // ================== PUT ==================

    // PUT /employee/1
    @PutMapping("/employee/{employeeId}")
    public ResponseEntity<Employee> updateEmployee(
            @PathVariable Long employeeId, @RequestBody Employee updatedEmployee) {

        Employee employee=employeeService.updateEmployee(employeeId, updatedEmployee);

        return ResponseEntity.ok(employee);
    }

    // ================== PATCH ==================

   // PATCH /employee/1?isActive=false
//    @PatchMapping("/{employeeId}")
//    public Employee updateEmployeeStatus(
//            @PathVariable Long employeeId,
//            @RequestParam Boolean isActive) {
//
//        return employeeService.getEmployeeById(employeeId)
//                .map(employee -> {
//                    employee.setIsActive(isActive);
//                    return employeeRepository.save(employee);
//                })
//                .orElseThrow(() -> new RuntimeException("Employee not found"));
//    }

    // ================== DELETE ==================

    // DELETE /employee/1
    @DeleteMapping("/{employeeId}")
    public String deleteEmployee(@PathVariable Long employeeId) {
        employeeService.deleteEmployee(employeeId);
        return "Employee with ID " + employeeId + " deleted successfully";
    }
}
