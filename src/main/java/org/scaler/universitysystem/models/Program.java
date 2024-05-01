package org.scaler.universitysystem.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@Entity
public class Program {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne
    private Department department;
    private String degreeLevel;
    @OneToMany
    private List<Admission> allAdmissions;
    private int duration;
}
