package org.scaler.universitysystem.service;

import org.scaler.universitysystem.models.Department;
import org.scaler.universitysystem.models.Program;
import org.scaler.universitysystem.repository.DepartmentRepository;
import org.scaler.universitysystem.repository.ProgramRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService{
    private final DepartmentRepository departmentRepository;
    private ProgramRepository programRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository, ProgramRepository programRepository) {
        this.departmentRepository = departmentRepository;
        this.programRepository = programRepository;
    }

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentById(Long id) {
        return departmentRepository.findById(id).get();
    }

    @Override
    public Department createDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public Department updateDepartment(Long id, Department department) {
        Optional<Department> existingDepartment = departmentRepository.findById(id);
        if (existingDepartment.isPresent()) {
            return departmentRepository.save(update(existingDepartment.get(), department));
        } else {
            // Throw an error or return null
            throw new RuntimeException("Department not found with id: " + id);
        }
    }

    @Override
    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
    }

    @Override
    public List<Program> getProgramsByDepartmentId(Long departmentId) {
        return programRepository.findByDepartmentId(departmentId);
    }

    public Department update(Department existingDepartment, Department updatedDepartment) {
        if(updatedDepartment.getName() != null) {
            existingDepartment.setName(updatedDepartment.getName());
        }
        if(updatedDepartment.getDescription() != null) {
            existingDepartment.setDescription(updatedDepartment.getDescription());
        }
        return departmentRepository.save(existingDepartment);
    }
}
