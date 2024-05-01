package org.scaler.universitysystem.repository;

import org.scaler.universitysystem.models.Admission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AdmissionRepository extends JpaRepository<Admission, Long> {
    @Override
    Admission save(Admission admission);
    @Override
    Optional<Admission> findById(Long id);
    @Override
    void deleteById(Long id);


    // list of admissions by program id
    List<Admission> findByProgramId(Long programId);



    // list of admissions by applicant id
    List<Admission> findByApplicantId(Long applicantId);

}
