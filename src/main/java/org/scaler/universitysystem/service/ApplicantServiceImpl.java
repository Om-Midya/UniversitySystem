package org.scaler.universitysystem.service;


import org.scaler.universitysystem.models.Applicant;
import org.scaler.universitysystem.repository.ApplicantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApplicantServiceImpl implements ApplicantService{

    private final ApplicantRepository applicantRepository;

    public ApplicantServiceImpl(ApplicantRepository applicantRepository) {
        this.applicantRepository = applicantRepository;
    }

    @Override
    public List<Applicant> getAllApplicants() {
        return applicantRepository.findAll();
    }

    @Override
    public Optional<Applicant> getApplicantById(Long id) {
        return applicantRepository.findById(id);
    }

    @Override
    public Applicant saveApplicant(Applicant applicant) {
        return applicantRepository.save(applicant);
    }

    @Override
    public Applicant updateApplicant(Applicant applicant) {
        return applicantRepository.save(applicant);
    }

    @Override
    public void deleteApplicantById(Long id) {
        applicantRepository.deleteById(id);
    }
}
