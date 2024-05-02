package org.scaler.universitysystem.service;


import org.scaler.universitysystem.exceptions.AdmissionNotFoundException;
import org.scaler.universitysystem.exceptions.ApplicantNotFoundException;
import org.scaler.universitysystem.models.Applicant;
import org.scaler.universitysystem.repository.ApplicantRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApplicantServiceImpl implements ApplicantService{

    private final ApplicantRepository applicantRepository;

    private static final Logger logger = LoggerFactory.getLogger(ApplicantServiceImpl.class);

    public ApplicantServiceImpl(ApplicantRepository applicantRepository) {
        this.applicantRepository = applicantRepository;
    }

    @Override
    public List<Applicant> getAllApplicants() {
        logger.info("Getting all applicants");
        return applicantRepository.findAll();
    }

    @Override
    public Optional<Applicant> getApplicantById(Long id) {
        logger.info("Getting applicant by id: {}", id);
        Optional<Applicant> applicant = applicantRepository.findById(id);
        if (applicant.isEmpty()){
            throw new ApplicantNotFoundException(id);
        }
        return applicantRepository.findById(id);
    }

    @Override
    public Applicant saveApplicant(Applicant applicant) {
        logger.info("Creating applicant with name: {}", applicant.getName());
        //if name or date or email or dateOfBirth is null, throw an exception
        if(applicant.getName() == null || applicant.getEmail() == null || applicant.getAddress() == null || applicant.getDateOfBirth() == null){
            throw new IllegalArgumentException("Name, Email, Address and Date of Birth are mandatory fields");
        }
        return applicantRepository.save(applicant);
    }

    @Override
    public Applicant updateApplicant(Applicant applicant) {
        logger.info("Updating applicant by id: {}", applicant.getId());
        Optional<Applicant> existingApplicant = applicantRepository.findById(applicant.getId());
        if (existingApplicant.isPresent()) {

            return applicantRepository.save(update(existingApplicant.get(), applicant));
        } else {
            // Throw an error or return null
            throw new ApplicantNotFoundException(applicant.getId());
        }
    }

    @Override
    public void deleteApplicantById(Long id) {
        logger.info("Deleting applicant by id: {}", id);
        Optional<Applicant> applicant = applicantRepository.findById(id);
        if (applicant.isEmpty()){
            throw new ApplicantNotFoundException(id);
        }
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
