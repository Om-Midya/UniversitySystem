package org.scaler.universitysystem.repository;

import org.scaler.universitysystem.models.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ApplicantRepository extends JpaRepository<Applicant, Long> {
    @Override
    Optional<Applicant> findById(Long id);
    @Override
    Applicant save(Applicant applicant);
    @Override
    void deleteById(Long id);
    @Override
    List<Applicant> findAll();


}
