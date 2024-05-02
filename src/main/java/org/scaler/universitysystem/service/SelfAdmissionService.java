package org.scaler.universitysystem.service;

import org.scaler.universitysystem.exceptions.AdmissionNotFoundException;
import org.scaler.universitysystem.exceptions.ApplicantNotFoundException;
import org.scaler.universitysystem.exceptions.ProgramNotFoundException;
import org.scaler.universitysystem.models.*;
import org.scaler.universitysystem.repository.AdmissionRepository;
import org.scaler.universitysystem.repository.ApplicantRepository;
import org.scaler.universitysystem.repository.ProgramRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class SelfAdmissionService implements AdmissionService{

    private AdmissionRepository admissionRepository;

    private ApplicantRepository applicantRepository;
    private ProgramRepository programRepository;

    public SelfAdmissionService(AdmissionRepository admissionRepository, ApplicantRepository applicantRepository, ProgramRepository programRepository) {
        this.admissionRepository = admissionRepository;
        this.applicantRepository = applicantRepository;
        this.programRepository = programRepository;
    }

    Logger logger = LoggerFactory.getLogger(SelfAdmissionService.class);

    @Override
    public Admission createAdmission(Admission admission) {
        logger.info("Creating admission for applicantId: {}, programId: {}", admission.getApplicant().getId(), admission.getProgram().getId());
        // if applicant or program is null, throw an exception
        if(admission.getApplicant() == null || admission.getProgram() == null){
            throw new IllegalArgumentException("Applicant and Program are mandatory fields");
        }


        // Check if the applicant and program exist
        Applicant applicant = applicantRepository.findById(admission.getApplicant().getId()).get();
        Program program = programRepository.findById(admission.getProgram().getId()).get();

        if (applicant == null){
            throw new ApplicantNotFoundException(admission.getApplicant().getId());
        }
        if (program == null){
            throw new ProgramNotFoundException(admission.getProgram().getId());
        }
        admission.setDecision(Decision.WAITLISTED);
        applicant.setApplicationStatus(ApplicationStatus.APPLIED);
        admission.setApplicant(applicant);
        admission.setProgram(program);
        Admission savedAdmission = admissionRepository.save(admission);
        return savedAdmission;
    }

    @Override
    public Admission getAdmissionById(Long id) {
        logger.info("Getting admission by id: {}", id);
        Optional<Admission> optionalAdmission = admissionRepository.findById(id);
        if(optionalAdmission.isEmpty()){
            throw new AdmissionNotFoundException(id);
        }
        return optionalAdmission.get();
    }

    @Override
    public List<Admission> getAllAdmissions() {
        logger.info("Getting all admissions");
        return admissionRepository.findAll();
    }


    @Override
    public Admission updateAdmission(Long id, Admission admission) {
        logger.info("Updating admission with id: {}", id);
//        Applicant applicant = applicantRepository.findById(admission.getApplicant().getId()).get();
//        if (admission.getDecision() == Decision.ACCEPTED){
//            applicant.setApplicationStatus(ApplicationStatus.ADMITTED);
//        }
        Optional<Admission> existingAdmission = admissionRepository.findById(id);
        if (existingAdmission.isPresent()) {
            Admission updatedAdmission = admissionRepository.save(update(existingAdmission.get(), admission));
            Applicant applicant = applicantRepository.findById(updatedAdmission.getApplicant().getId()).get();
            if (updatedAdmission.getDecision() == Decision.ACCEPTED){
                applicant.setApplicationStatus(ApplicationStatus.ADMITTED);
            }
            applicantRepository.save(applicant);
            return updatedAdmission;
        } else {
            throw new AdmissionNotFoundException(id);
        }
    }

    @Override
    public void deleteAdmission(Long id) {
        logger.info("Deleting admission with id: {}", id);
        Optional<Admission> admission = admissionRepository.findById(id);
        if (admission.isEmpty()){
            throw new AdmissionNotFoundException(id);
        }

        admissionRepository.deleteById(id);

    }

    @Override
    public List<Admission> getAdmissionsByProgram(Long programId) {
        logger.info("Getting admissions by programId: {}", programId);
        Optional<Program> program = programRepository.findById(programId);
        if (program.isEmpty()){
            throw new ProgramNotFoundException(programId);
        }
        return admissionRepository.findByProgramId(programId);
    }

    @Override
    public List<Admission> getAdmissionsByApplicant(Long applicantId) {
        logger.info("Getting admissions by applicantId: {}", applicantId);
        Optional<Applicant> applicant = applicantRepository.findById(applicantId);
        if (applicant.isEmpty()){
            throw new ApplicantNotFoundException(applicantId);
        }
        return admissionRepository.findByApplicantId(applicantId);
    }

    public Admission update(Admission existingAdmission, Admission updatedAdmission) {
        if(updatedAdmission.getDecision() != null)
            existingAdmission.setDecision(updatedAdmission.getDecision());
        if(updatedAdmission.getDecisionDate() != null){
            existingAdmission.setDecisionDate(updatedAdmission.getDecisionDate());
        }
        return existingAdmission;
    }
}
