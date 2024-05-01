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
        Optional<Applicant> existingApplicant = applicantRepository.findById(applicant.getId());
        if (existingApplicant.isPresent()) {

            return applicantRepository.save(update(existingApplicant.get(), applicant));
        } else {
            // Throw an error or return null
            throw new RuntimeException("Applicant not found with id: " + applicant.getId());
        }
    }

    @Override
    public void deleteApplicantById(Long id) {
        applicantRepository.deleteById(id);
    }

    public Applicant update(Applicant existingApplicant, Applicant updatedApplicant){
        if(updatedApplicant.getName() != null){
            existingApplicant.setName(updatedApplicant.getName());
        }
        if(updatedApplicant.getEmail() != null){
            existingApplicant.setEmail(updatedApplicant.getEmail());
        }
        if(updatedApplicant.getAddress() != null){
            existingApplicant.setAddress(updatedApplicant.getAddress());
        }
        if(updatedApplicant.getDateOfBirth() != null){
            existingApplicant.setDateOfBirth(updatedApplicant.getDateOfBirth());
        }
        return existingApplicant;
    }
}
