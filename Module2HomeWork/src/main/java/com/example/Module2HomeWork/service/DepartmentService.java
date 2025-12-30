package com.example.Module2HomeWork.service;

import java.util.List;

import com.example.Module2HomeWork.dto.DepartmentDTO;

public interface DepartmentService {
	DepartmentDTO createDepartment(DepartmentDTO dto);
	List<DepartmentDTO> getAllDepartments();
	DepartmentDTO getDepartmentById(Long id);
	DepartmentDTO updateDepartment(DepartmentDTO dto);
	void deleteDepartment(Long id);
}
