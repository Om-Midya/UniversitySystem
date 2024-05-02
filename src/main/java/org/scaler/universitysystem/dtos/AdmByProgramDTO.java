package org.scaler.universitysystem.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.scaler.universitysystem.models.Decision;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AdmByProgramDTO {
    private Long admissionId;
    private String programName;
    private String applicantName;
    private String applicantEmail;
    private Decision admissionDecision;



}
