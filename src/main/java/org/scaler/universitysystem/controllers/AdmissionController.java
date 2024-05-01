package org.scaler.universitysystem.controllers;


import org.scaler.universitysystem.models.Admission;
import org.scaler.universitysystem.service.AdmissionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admissions")
public class AdmissionController {

    private AdmissionService admissionService;

    AdmissionController(AdmissionService admissionService) {
        this.admissionService = admissionService;
    }

    // Implement the following endpoints
    // CRUD operations for Admission
    // GET /admissions
    // GET /admissions/{id}
    @GetMapping( "/{id}")
    public Admission getAdmissionById(@PathVariable("id") Long id) {
        return admissionService.getAdmissionById(id);
    }


    // POST /admissions
    @PostMapping
    public Admission createAdmission(@RequestBody Admission admission) {
        return admissionService.createAdmission(admission);
    }

    // PUT /admissions/{id}
    @PutMapping("/{id}")
    public Admission updateAdmission(@PathVariable("id") Long id, @RequestBody Admission admission) {
        return admissionService.updateAdmission(id, admission);
    }


    // DELETE /admissions/{id}
    @DeleteMapping("/{id}")
    public void deleteAdmission(@PathVariable("id") Long id) {
        admissionService.deleteAdmission(id);
    }


    //get all admissions for a specific Program
    //GET /admissions/program/{programId}
    @GetMapping("/program/{programId}")
    public List<Admission> getAdmissionsByProgram(@PathVariable("programId") Long programId) {
        return admissionService.getAdmissionsByProgram(programId);
    }



    //get all admissions for a specific Applicant
    //GET /admissions/applicant/{applicantId}
    @GetMapping("/applicant/{applicantId}")
    public List<Admission> getAdmissionsByApplicant(@PathVariable("applicantId") Long applicantId) {
        return admissionService.getAdmissionsByApplicant(applicantId);
    }


}
