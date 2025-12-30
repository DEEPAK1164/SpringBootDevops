package com.example.Module2HomeWork.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Module2HomeWork.advices.ApiResponse;
import com.example.Module2HomeWork.dto.DepartmentDTO;
import com.example.Module2HomeWork.service.DepartmentService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/departments")
@RequiredArgsConstructor
public class DepartmentController {
private final DepartmentService service;

@PostMapping
public ResponseEntity<ApiResponse<DepartmentDTO>> create(@Valid
@RequestBody DepartmentDTO dto) {
return ResponseEntity.ok(new
ApiResponse<>(service.createDepartment(dto)));
}

@GetMapping
public ResponseEntity<ApiResponse<List<DepartmentDTO>>> getAll() {
return ResponseEntity.ok(new
ApiResponse<>(service.getAllDepartments()));
}

@GetMapping("/{id}")
public ResponseEntity<ApiResponse<DepartmentDTO>> getById(@PathVariable
Long id) {
return ResponseEntity.ok(new
ApiResponse<>(service.getDepartmentById(id)));
}

@PutMapping
public ResponseEntity<ApiResponse<DepartmentDTO>> update(@Valid
@RequestBody DepartmentDTO dto) {
return ResponseEntity.ok(new
ApiResponse<>(service.updateDepartment(dto)));
}

@DeleteMapping("/{id}")
public ResponseEntity<ApiResponse<String>> delete(@PathVariable Long id) {
service.deleteDepartment(id);
return ResponseEntity.ok(new ApiResponse<>("Department deleted successfully"));
}
}
