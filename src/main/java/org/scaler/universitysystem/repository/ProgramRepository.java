package org.scaler.universitysystem.repository;

import org.scaler.universitysystem.models.Program;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProgramRepository extends JpaRepository<Program, Long> {
}
