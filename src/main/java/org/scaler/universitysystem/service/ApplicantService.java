package org.scaler.universitysystem.service;

import org.scaler.universitysystem.models.Applicant;

import java.util.List;
import java.util.Optional;

public interface ApplicantService {
    public List<Applicant> getAllApplicants();
    public Optional<Applicant> getApplicantById(Long id);
    public Applicant saveApplicant(Applicant applicant);
    public Applicant updateApplicant(Applicant applicant);
    public void deleteApplicantById(Long id);
}
