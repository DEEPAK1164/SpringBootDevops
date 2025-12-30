package com.example.Module2HomeWork.service;
import java.time.LocalDateTime;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import com.example.Module2HomeWork.dto.DepartmentDTO;
import com.example.Module2HomeWork.entity.Department;
import com.example.Module2HomeWork.exceptions.ResourceNotFoundException;
import com.example.Module2HomeWork.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
private final DepartmentRepository repository;
private final ModelMapper modelMapper;
@Override
public DepartmentDTO createDepartment(DepartmentDTO dto) {
Department dept = modelMapper.map(dto, Department.class);
dept.setCreatedAt(LocalDateTime.now());
return modelMapper.map(repository.save(dept), DepartmentDTO.class);
}
@Override
public List<DepartmentDTO> getAllDepartments() {
return repository.findAll()
.stream()
.map(d -> modelMapper.map(d, DepartmentDTO.class))
.toList();
}

@Override
public DepartmentDTO getDepartmentById(Long id) {
    Department dept = repository.findById(id)
   .orElseThrow(() -> new
    ResourceNotFoundException("Department not found with id " + id));
    return modelMapper.map(dept, DepartmentDTO.class);
}

@Override
public DepartmentDTO updateDepartment(DepartmentDTO dto) {
    Department dept = repository.findById(dto.getId())
   .orElseThrow(() -> new
    ResourceNotFoundException("Department not found"));
    modelMapper.map(dto, dept);
return modelMapper.map(repository.save(dept), DepartmentDTO.class);
}

@Override
public void deleteDepartment(Long id) {
    Department dept = repository.findById(id)
   .orElseThrow(() -> new
    ResourceNotFoundException("Department not found"));
    repository.delete(dept);
}

}
