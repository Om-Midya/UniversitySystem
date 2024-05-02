package org.scaler.universitysystem.repository;

import org.scaler.universitysystem.models.Department;
import org.scaler.universitysystem.models.Program;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    @Override
    Optional<Department> findById(Long id);
    @Override
    Department save(Department department);
    @Override
    void deleteById(Long id);
    @Override
    List<Department> findAll();
}
