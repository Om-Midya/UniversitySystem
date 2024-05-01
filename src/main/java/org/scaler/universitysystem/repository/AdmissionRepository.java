package org.scaler.universitysystem.repository;

import org.scaler.universitysystem.models.Admission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdmissionRepository extends JpaRepository<Admission, Long> {
}
