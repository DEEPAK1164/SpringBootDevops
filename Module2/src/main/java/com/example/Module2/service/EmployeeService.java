package com.example.Module2.service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.data.util.ReflectionUtils;
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

	    Employee employee = employeeRepository.findById(employeeId)
	            .orElse(null);

	    if (employee == null) {
	        return null; // 👈 important
	    }

	    return modelMapper.map(employee, EmployeeDTO.class);
	}


   public List<EmployeeDTO> getAllEmployees() {

	    List<Employee> employees = employeeRepository.findAll();

	    List<EmployeeDTO> allEmployees = employees.stream()
	            .map(employee -> modelMapper.map(employee, EmployeeDTO.class))
	            .collect(Collectors.toList());

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

   public EmployeeDTO updateEmployeeById(Long employeeId, EmployeeDTO employeeDTO) {
	   //don't throw error if this employee does not exist in DB create employee with this EmployeeDTO and put in DB otherwise update the employee
	   Employee employee=modelMapper.map(employeeDTO, Employee.class);
	   employee.setId(employeeId);
	   Employee savedEmployee=employeeRepository.save(employee);
	return modelMapper.map(savedEmployee,EmployeeDTO.class);   
	}


   public void deleteEmployeeById(Long employeeId) {

	    Employee employee = employeeRepository.findById(employeeId)
	            .orElseThrow(() -> new RuntimeException("Employee not found"));

	    employeeRepository.delete(employee);
	}


   public EmployeeDTO updatePartialEmployeeById(Long employeeId, Map<String, Object> updates) {
	// TODO Auto-generated method stub
	   boolean exists=employeeRepository.existsById(employeeId);
	   if(!exists) return null;
	   Employee employee = employeeRepository.findById(employeeId).get();
	     updates.forEach((field,value)->{
	    	 Field fieldToBeUpdated=ReflectionUtils.findRequiredField(Employee.class, field);
	    	 fieldToBeUpdated.setAccessible(true);
	    	 ReflectionUtils.setField(fieldToBeUpdated, employee, value);
	     });
	     
	     return modelMapper.map(employeeRepository.save(employee),EmployeeDTO.class);
   }


}
