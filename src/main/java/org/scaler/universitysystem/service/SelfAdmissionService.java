package org.scaler.universitysystem.service;

import org.scaler.universitysystem.models.*;
import org.scaler.universitysystem.repository.AdmissionRepository;
import org.scaler.universitysystem.repository.ApplicantRepository;
import org.scaler.universitysystem.repository.ProgramRepository;
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

    @Override
    public Admission createAdmission(Admission admission) {
        Applicant applicant = applicantRepository.findById(admission.getApplicant().getId()).get();
        Program program = programRepository.findById(admission.getProgram().getId()).get();
        admission.setDecision(Decision.WAITLISTED);
        applicant.setApplicationStatus(ApplicationStatus.APPLIED);
        Admission savedAdmission = admissionRepository.save(admission);

        savedAdmission.setApplicant(applicant);
        savedAdmission.setProgram(program);
        return savedAdmission;
    }

    @Override
    public Admission getAdmissionById(Long id) {

        Optional<Admission> optionalAdmission = admissionRepository.findById(id);
        return optionalAdmission.get();
    }


    @Override
    public Admission updateAdmission(Long id, Admission admission) {
        Applicant applicant = applicantRepository.findById(admission.getApplicant().getId()).get();
        if (admission.getDecision() == Decision.ACCEPTED){
            applicant.setApplicationStatus(ApplicationStatus.ADMITTED);
        }
        return admissionRepository.save(admission);
    }

    @Override
    public void deleteAdmission(Long id) {

        admissionRepository.deleteById(id);

    }

    @Override
    public List<Admission> getAdmissionsByProgram(Long programId) {
        return admissionRepository.findByProgramId(programId);
    }

    @Override
    public List<Admission> getAdmissionsByApplicant(Long applicantId) {
        return admissionRepository.findByApplicantId(applicantId);
    }
}
