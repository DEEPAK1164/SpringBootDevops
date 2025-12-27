package com.example.Module2.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.Module2.model.Employee;
import com.example.Module2.repo.EmployeeRepository;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    // Constructor Injection
    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    // ================== GET ==================

    // GET /employee/1
    @GetMapping("/{employeeId}")
    public Employee getEmployeeById(@PathVariable Long employeeId) {
        return employeeRepository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    // GET /employee
    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // ================== POST ==================

    // POST /employee
    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    // ================== PUT ==================

    // PUT /employee/1
    @PutMapping("/{employeeId}")
    public Employee updateEmployee(
            @PathVariable Long employeeId,
            @RequestBody Employee updatedEmployee) {

        return employeeRepository.findById(employeeId)
                .map(existingEmployee -> {

                    existingEmployee.setName(updatedEmployee.getName());
                    existingEmployee.setEmail(updatedEmployee.getEmail());
                    existingEmployee.setAge(updatedEmployee.getAge());
                    existingEmployee.setDateOfJoining(updatedEmployee.getDateOfJoining());
                    existingEmployee.setIsActive(updatedEmployee.getIsActive());

                    return employeeRepository.save(existingEmployee);
                })
                .orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    // ================== PATCH ==================

    // PATCH /employee/1?isActive=false
    @PatchMapping("/{employeeId}")
    public Employee updateEmployeeStatus(
            @PathVariable Long employeeId,
            @RequestParam Boolean isActive) {

        return employeeRepository.findById(employeeId)
                .map(employee -> {
                    employee.setIsActive(isActive);
                    return employeeRepository.save(employee);
                })
                .orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    // ================== DELETE ==================

    // DELETE /employee/1
    @DeleteMapping("/{employeeId}")
    public String deleteEmployee(@PathVariable Long employeeId) {
        employeeRepository.deleteById(employeeId);
        return "Employee with ID " + employeeId + " deleted successfully";
    }
}
