package org.scaler.universitysystem.service;

import org.scaler.universitysystem.models.Admission;
import org.springframework.stereotype.Service;

import java.util.List;


public interface AdmissionService {
    Admission getAdmissionById(Long id);
    List<Admission> getAllAdmissions();
    Admission createAdmission(Admission admission);
    Admission updateAdmission(Long id, Admission admission);
    void deleteAdmission(Long id);
    List<Admission> getAdmissionsByProgram(Long programId);
    List<Admission> getAdmissionsByApplicant(Long applicantId);

}
