package org.scaler.universitysystem.repository;

import org.scaler.universitysystem.models.Program;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProgramRepository extends JpaRepository<Program, Long> {
    @Override
    Program save(Program program);
    @Override
    Optional<Program> findById(Long id);
    @Override
    void deleteById(Long id);

    // list of programs by department id
    List<Program> findByDepartmentId(Long departmentId);

}
