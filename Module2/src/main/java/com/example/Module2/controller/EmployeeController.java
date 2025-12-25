package com.example.Module2.controller;

import java.time.LocalDate;

import org.springframework.web.bind.annotation.*;

import com.example.Module2.dto.EmployeeDTO;

@RestController
public class EmployeeController {

    // ✅ GET - PathVariable
    @GetMapping("/employee/{employeeId}")
    public EmployeeDTO getEmployeeById(@PathVariable Long employeeId) {
        return new EmployeeDTO(
                employeeId,
                "Deepak Maurya",
                "deepak@example.com",
                24,
                LocalDate.of(2023, 6, 1),
                true
        );
    }

    // ✅ GET - RequestParam
    @GetMapping("/employee")
    public EmployeeDTO getEmployeeByIdUsingRequestParam(
            @RequestParam Long employeeId) {

        return new EmployeeDTO(
                employeeId,
                "Deepak Maurya",
                "deepak@example.com",
                24,
                LocalDate.of(2023, 6, 1),
                true
        );
    }

    // ✅ POST - Create Employee
    @PostMapping("/employee")
    public EmployeeDTO createEmployee(@RequestBody EmployeeDTO employeeDTO) {
        // dummy create logic
        employeeDTO.setId(101L);
        return employeeDTO;
    }

    // ✅ PUT - Full Update Employee
    @PutMapping("/employee/{employeeId}")
    public EmployeeDTO updateEmployee(
            @PathVariable Long employeeId,
            @RequestBody EmployeeDTO employeeDTO) {

        employeeDTO.setId(employeeId);
        return employeeDTO;
    }

    // ✅ PATCH - Partial Update
    @PatchMapping("/employee/{employeeId}")
    public EmployeeDTO updateEmployeeStatus(
            @PathVariable Long employeeId,
            @RequestParam Boolean isActive) {

        return new EmployeeDTO(
                employeeId,
                "Deepak Maurya",
                "deepak@example.com",
                24,
                LocalDate.of(2023, 6, 1),
                isActive
        );
    }

    // ✅ DELETE - Delete Employee
    @DeleteMapping("/employee/{employeeId}")
    public String deleteEmployee(@PathVariable Long employeeId) {
        return "Employee with ID " + employeeId + " deleted successfully";
    }
}
