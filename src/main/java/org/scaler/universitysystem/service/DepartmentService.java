package org.scaler.universitysystem.service;

import org.scaler.universitysystem.models.Department;
import org.scaler.universitysystem.models.Program;
import org.scaler.universitysystem.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {
    public List<Department> getAllDepartments();
    public Department getDepartmentById(Long id);
    public Department createDepartment(Department department);
    public Department updateDepartment(Long id,Department department);
    public void deleteDepartment(Long id);
    List<Program> getProgramsByDepartmentId(Long departmentId);
}
