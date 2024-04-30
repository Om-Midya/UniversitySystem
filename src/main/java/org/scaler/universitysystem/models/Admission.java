package org.scaler.universitysystem.models;


import ch.qos.logback.core.joran.action.AppenderAction;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
public class Admission {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private Applicant applicant;
    @ManyToOne
    private Program program;
    private String decision;
    private Date decisionDate;
}
