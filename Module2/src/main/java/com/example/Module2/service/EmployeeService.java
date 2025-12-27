package com.example.Module2.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.Module2.dto.EmployeeDTO;
import com.example.Module2.model.Employee;
import com.example.Module2.repo.EmployeeRepository;

@Service
public class EmployeeService {
   private final EmployeeRepository employeeRepository;
   private final ModelMapper modelMapper;
   
   //constructor way of dependency injection
   public EmployeeService (EmployeeRepository employeeRepository,ModelMapper modelMapper) {
	   this.employeeRepository=employeeRepository;
	   this.modelMapper=modelMapper;
   }
   

   public EmployeeDTO getEmployeeById(Long employeeId) {
	   Employee emp=employeeRepository.findById(employeeId).orElse(null);
       return modelMapper.map(emp, EmployeeDTO.class);
   }

   public List<EmployeeDTO> getAllEmployees() {

	    List<Employee> employees = employeeRepository.findAll();

	    List<EmployeeDTO> allEmployees = employees.stream()
	            .map(employee -> modelMapper.map(employee, EmployeeDTO.class))
	            .toList();

	    return allEmployees;
	}


   public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {

	    // DTO → Entity
	    Employee employee = modelMapper.map(employeeDTO, Employee.class);

	    // Save entity
	    Employee savedEmployee = employeeRepository.save(employee);

	    // Entity → DTO
	    return modelMapper.map(savedEmployee, EmployeeDTO.class);
	}

   
   public Employee updateEmployee(Long employeeId, Employee updatedEmployee) {

       Employee existingEmployee = employeeRepository.findById(employeeId).orElse(null);
               

       // update fields
       existingEmployee.setName(updatedEmployee.getName());
       existingEmployee.setEmail(updatedEmployee.getEmail());
       existingEmployee.setAge(updatedEmployee.getAge());
       existingEmployee.setDateOfJoining(updatedEmployee.getDateOfJoining());
       existingEmployee.setIsActive(updatedEmployee.getIsActive());

       return employeeRepository.save(existingEmployee);
   }



   public void deleteEmployee(Long employeeId) {

	    Employee employee = employeeRepository.findById(employeeId)
	            .orElseThrow(() -> new RuntimeException("Employee not found"));

	    employeeRepository.delete(employee);
	}


}
