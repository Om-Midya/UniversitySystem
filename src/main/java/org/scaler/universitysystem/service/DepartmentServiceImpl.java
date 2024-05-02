package org.scaler.universitysystem.service;

import org.scaler.universitysystem.exceptions.DepartmentNotFoundException;
import org.scaler.universitysystem.models.Department;
import org.scaler.universitysystem.models.Program;
import org.scaler.universitysystem.repository.DepartmentRepository;
import org.scaler.universitysystem.repository.ProgramRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService{
    private final DepartmentRepository departmentRepository;
    private ProgramRepository programRepository;

    private static final Logger logger = LoggerFactory.getLogger(SelfProgramService.class);

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
        logger.info("Getting department by id: {}", id);
        Optional<Department> department = departmentRepository.findById(id);
        if (department.isEmpty()){
            throw new DepartmentNotFoundException(id);
        }
        return departmentRepository.findById(id).get();
    }

    @Override
    public Department createDepartment(Department department) {
        logger.info("Creating department with name: {}", department.getName());
        //if name or description is null, throw an exception
        if(department.getName() == null || department.getDescription() == null){
            throw new IllegalArgumentException("Name and Description are mandatory fields");
        }
        return departmentRepository.save(department);
    }

    @Override
    public Department updateDepartment(Long id, Department department) {
        logger.info("Updating department by id: {}", id);
        Optional<Department> existingDepartment = departmentRepository.findById(id);
        if (existingDepartment.isPresent()) {
            return departmentRepository.save(update(existingDepartment.get(), department));
        } else {
            // Throw an error or return null
            throw new DepartmentNotFoundException(id);
        }
    }

    @Override
    public void deleteDepartment(Long id) {
        logger.info("Deleting department by id: {}", id);
        Optional<Department> department = departmentRepository.findById(id);
        if (department.isEmpty()){
            throw new DepartmentNotFoundException(id);
        }
        departmentRepository.deleteById(id);
    }

    @Override
    public List<Program> getProgramsByDepartmentId(Long departmentId) {
        logger.info("Getting programs by department id: {}", departmentId);
        Optional<Department> department = departmentRepository.findById(departmentId);
        if (department.isEmpty()){
            throw new DepartmentNotFoundException(departmentId);
        }
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
