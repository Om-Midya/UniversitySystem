package org.scaler.universitysystem.controllers;


import org.scaler.universitysystem.dtos.ApplicantStatusDTO;
import org.scaler.universitysystem.models.Applicant;
import org.scaler.universitysystem.service.ApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/applicants")
public class ApplicantController {

    private final ApplicantService applicantService;
    public ApplicantController(ApplicantService applicantService) {
        this.applicantService = applicantService;
    }

    @GetMapping
    public List<Applicant> getAllApplicants() {
        return applicantService.getAllApplicants();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Applicant> getApplicantById(@PathVariable Long id) {
        return applicantService.getApplicantById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Applicant createApplicant(@RequestBody Applicant applicant) {
        return applicantService.saveApplicant(applicant);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Applicant> updateApplicant(@PathVariable Long id, @RequestBody Applicant applicant) {
        return applicantService.getApplicantById(id)
                .map(existingApplicant -> {
                    applicant.setId(id);
                    return ResponseEntity.ok(applicantService.updateApplicant(applicant));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteApplicant(@PathVariable Long id) {
        return applicantService.getApplicantById(id)
                .map(applicant -> {
                    applicantService.deleteApplicantById(id);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/status/{id}")
    public ResponseEntity<ApplicantStatusDTO> getApplicantStatus(@PathVariable Long id) {
        return ResponseEntity.ok(applicantService.getApplicantStatus(id));
    }


}
