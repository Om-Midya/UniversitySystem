package org.scaler.universitysystem.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.scaler.universitysystem.models.ApplicationStatus;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApplicantStatusDTO {
    private String applicantName;
    private String applicantEmail;
    private ApplicationStatus applicationStatus;
}
