package org.scaler.universitysystem.repository;

import org.scaler.universitysystem.models.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
